package com.company;

public interface SetObserver<Integer> {
    void added(ObservableSet<Integer> set, Integer element);
}
