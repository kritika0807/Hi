package com.company;

import java.util.*;

public class ForwardingSet<Integer> implements Set<Integer> {
    public Set<Integer> s ;
    public Set<Integer> s1 ;
    ForwardingSet(Set<Integer> s) {
        this.s=s;
    }

    @Override
    public int size() {
        return s.size();
    }

    @Override
    public boolean isEmpty() {
        return s.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return s.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return s.iterator();
    }

    @Override
    public Object[] toArray() {
        return  s.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return s.toArray(a);
    }

    @Override
    public boolean add(Integer integer) {
        return s.add(integer);
    }

    @Override
    public boolean remove(Object o) {
        return s.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return s.contains(c);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return s.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return s.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return s.removeAll(c);
    }

    @Override
    public void clear() {
             s.clear();
    }
}
