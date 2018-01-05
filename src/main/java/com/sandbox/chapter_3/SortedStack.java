package com.sandbox.chapter_3;

import java.util.EmptyStackException;

/**
 * 3.5 Sorted Stack
 *
 * @author {@link "markvaldez@gmail.com"}
 */
public class SortedStack<T extends Comparable<T>> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(T data) {
        StackNode<T> t = new StackNode<>(data);
        t.next = top;
        top = t;
        sort();
    }

    private void pushNoSort(T data) {
        StackNode<T> t = new StackNode<>(data);
        t.next = top;
        top = t;
    }

    private void sort() {
        if (top == null) return;
        T val = this.pop();

        // no more values in stack
        if (this.isEmpty()) {
            this.pushNoSort(val);
            return;
        }

        MyStack<T> tmp = new MyStack<>();

        // find location
        while (!this.isEmpty()) {
            int c = val.compareTo(this.peek());
            if (c <= 0) {
                // found location
                tmp.push(val);
                break; // end search
            } else {
                tmp.push(this.pop());

                // if no more values
                // store compare value
                if (this.isEmpty()) {
                    tmp.push(val);
                }
            }
        }

        // restore from tmp stack
        while (!tmp.isEmpty()) {
            this.pushNoSort(tmp.pop());
        }
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        StackNode<T> n = top;
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.data);
            sb.append(", ");
            n = n.next;
        }
        return sb.toString();
    }
}
