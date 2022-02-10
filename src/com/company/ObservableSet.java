package com.company;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableSet<Integer> extends ForwardingSet<Integer>{
    ObservableSet(Set<Integer> s) {
        super(s);
    }
    private  final List<SetObserver<Integer>> observers
            = new ArrayList<>();
    public void addObserver (SetObserver<Integer> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }
    public boolean removeObserver (SetObserver < Integer > observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }
        private void notifyElementAdded (Integer element){
        List<SetObserver<Integer>> snapshot ;
        synchronized (observers) {
            snapshot=new ArrayList<>(observers);
            for (SetObserver<Integer> observer : snapshot)
                observer.added(this, element);
        }
    }
    @Override
        public boolean add(Integer element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }
    @Override public boolean addAll(Collection<? extends Integer> c) {
        boolean result = false;
        for (Integer element : c)
            result|=add(element); //Calls notifyElementAdded return result;
        return result;
    }
    public static void main(String[] args) {
         ObservableSet<java.lang.Integer> set =
                new ObservableSet<>(new HashSet<>());


         //  set.addObserver((s, e) -> System.out.println(e));
        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<java.lang.Integer> s, java.lang.Integer e) {
                System.out.println(e);
                if (e == 23) {
                    ExecutorService exec =
                            Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> s.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) { throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    } }
            } });
//                if (e == 23) {
//                    ExecutorService exec =
//                            Executors.newSingleThreadExecutor();
//                    try {
//                        exec.submit(() -> s.removeObserver(this)).get();
//                    } catch (ExecutionException | InterruptedException ex) { throw new AssertionError(ex);
//                    } finally {
//                        exec.shutdown();
//                    } }
//            } });

        for (int i = 0; i < 100; i++){
            //System.out.println("hi");
            set.add(i);
        }



    }

}
