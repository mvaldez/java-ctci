package com.sandbox.chapter_3;

import java.util.*;

/**
 * 3.3 Stack of Plates
 *
 * @author {@link "markvaldez@gmail.com"}
 */
public class SetOfStacks<T extends Comparable<T>> {
    private final static int THRESHOLD = 2; // zero based
    private List<MyStack<T>> stackList = null;
    private int index = 0;
    private Map<Integer, Integer> indexCount = new HashMap<>();

    public SetOfStacks<T> push(T item) {
        if (stackList == null) {
            stackList = new ArrayList<>();
            stackList.add(new MyStack<>());
            indexCount.put(index, 0);
        }
        if (indexCount.get(index) > THRESHOLD) {
            System.out.println("Creating new stack");
            stackList.add(new MyStack<>());
            index++;
            indexCount.put(index, 0);
        }
        stackList.get(index).push(item);
        indexCount.put(index, indexCount.get(index) + 1);
        return this;
    }

    public T peek() {
        if (stackList == null) throw new EmptyStackException();
        if(isEmpty()) {
            stackList.remove(index);
            index--;
        }

        if (index < 0) {
            index = 0; // reset
            indexCount.put(index, 0); // reset
            throw new EmptyStackException();
        }

        return stackList.get(index).peek();
    }

    public T pop() {
        if (stackList == null) throw new EmptyStackException();

        if(isEmpty()) {
            stackList.remove(index);
            index--;
        }

        if (index < 0) {
            index = 0; // reset
            indexCount.put(index, 0); // reset
            throw new EmptyStackException();
        }
        indexCount.put(index, indexCount.get(index) - 1);
        return stackList.get(index).pop();
    }

    public T popAt(int index) {
        if (stackList == null) throw new EmptyStackException();
        if (stackList.get(index) == null) throw new IllegalArgumentException();
        if (isEmptyAt(index)) throw new EmptyStackException();

        indexCount.put(index, indexCount.get(index) - 1);
        return stackList.get(index).pop();
    }

    private Boolean isEmpty() {
        try {
            stackList.get(index).peek();
        } catch (EmptyStackException e) {
            return true;
        }
        return false;
    }

    private Boolean isEmptyAt(int index) {
        try {
            stackList.get(index).peek();
        } catch (EmptyStackException e) {
            return true;
        }
        return false;
    }


}
