package com.sandbox.chapter_3;

import java.util.EmptyStackException;

/**
 * TODO: JAVADOC ME
 *
 * @author {@link "markvaldez@gmail.com"}
 */
public class MyStack<T extends Comparable<T>> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;
    private T min; // 3.2 Stack Min

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        if (item.compareTo(this.min) == 0) {
            // this is the min item
            // search for smallest value
            min = findMin(top.next);
        }

        top = top.next;
        return item;
    }

    private T findMin(StackNode<T> head) {
        if (head == null) return null;
        StackNode<T> n = head;
        T min = head.data;
        while (n != null) {
            if (n.data.compareTo(min) < 0) {
                min = n.data;
            }
            n = n.next;
        }
        return min;
    }

    public T getMin() {
        return min;
    }

    public MyStack<T> push(T item) {
        StackNode<T> t = new StackNode<>(item);
        if (min == null) {
            min = item;
        } else if (this.min.compareTo(item) > 0) {
            this.min = item;
        } else {
            // do nothing if equal or greater than
        }
        t.next = top;
        top = t;
        return this;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
