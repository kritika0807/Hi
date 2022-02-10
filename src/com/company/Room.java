package com.company;

import java.lang.ref.Cleaner;

 public class Room implements AutoCloseable{
    private static final Cleaner cleaner = Cleaner.create();
     static class State implements Runnable {
        int numJunk;
    State(int numJunk){
        this.numJunk=numJunk;
    }

        public void run() {
            System.out.println("Cleaning the Room");
            numJunk=0;
            System.out.println(numJunk);
        }
    }
    final State state;
    final Cleaner.Cleanable cleanable;
    Room(int numJunk){
         state = new State(numJunk);
        cleanable =cleaner.register(this, state);
    }

     @Override
     public void close() {
        cleanable.clean();
     }

    }

