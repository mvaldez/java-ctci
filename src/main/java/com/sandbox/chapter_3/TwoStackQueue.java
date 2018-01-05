package com.sandbox.chapter_3;

import java.util.EmptyStackException;

/**
 * TODO: JAVADOC ME
 *
 * @author {@link "markvaldez@gmail.com"}
 */
public class TwoStackQueue<T extends Comparable<T>> {

    private final MyStack<T> firstStack = new MyStack<>();
    private final MyStack<T> secondStack = new MyStack<>();

    public TwoStackQueue<T> push(T item) {
        firstStack.push(item);
        return this;
    }

    public T pop() {
        if (secondStack.isEmpty()) {
            shiftStacks();
        }
        return secondStack.pop();
    }

    public T peek() {
        if (secondStack.isEmpty()) {
            shiftStacks();
        }
        return secondStack.peek();
    }

    private void shiftStacks() {
        if (firstStack.isEmpty()) {
            throw new EmptyStackException();
        }

        while (!firstStack.isEmpty()) {
            T item = firstStack.pop();
            secondStack.push(item);
        }
    }
}
