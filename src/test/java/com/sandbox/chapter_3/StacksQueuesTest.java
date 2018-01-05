package com.sandbox.chapter_3;


import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 *
 * @author {@link "markvaldez@gmail.com"}
 */
public class StacksQueuesTest {

    @Test
    public void StackTest() {
        MyStack<String> s = new MyStack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        s.pop();
        assertEquals("B", s.peek());
        assertEquals("B", s.pop());
        assertEquals("A", s.pop());
    }

    @Test
    public void QueueTest() {
        MyQueue<String> q = new MyQueue<>();
        q.add("A");
        q.add("B");
        q.add("C");

        assertFalse(q.isEmpty());
        assertEquals("A", q.peek());

        q.remove();

        assertEquals("B", q.peek());
    }

    @Test
    public void MinTest() {
        MyStack<Integer> s = new MyStack<>();
        s.push(10)
                .push(11)
                .push(20)
                .push(8)
                .push(13)
                .push(12);

        assertEquals(new Integer(8), s.getMin());

        s.pop();
        s.pop();

        assertEquals(new Integer(8), s.getMin());

        s.pop();

        assertEquals(new Integer(10), s.getMin());

        s.pop();
        s.pop();

        assertEquals(new Integer(10), s.getMin());

        s.pop();

        assertNull(s.getMin());
    }

    @Test
    public void SetOfStacksTest() {
        SetOfStacks<String> ss = new SetOfStacks<>();
        ss.push("A")
                .push("B")
                .push("C")
                .push("D")
                .push("E");

        ss.pop();
        ss.pop();
        ss.pop();

        assertEquals("B", ss.peek());
        assertEquals("B", ss.pop());
        assertEquals("A", ss.pop());

        ss.push("X")
                .push("Y")
                .push("Z")
                .push("XX")
                .push("YY")
                .push("ZZ");
    }

    @Test
    public void setOfStackPopAtTest() {
        SetOfStacks<String> ss = new SetOfStacks<>();
        ss.push("A")
                .push("B")
                .push("C")
                .push("D") // new stack
                .push("E")
                .push("X")
                .push("Y")
                .push("Z") // new stack
                .push("XX")
                .push("YY")
                .push("ZZ")
                .push("Last"); // new stack
        // this should have created 3 stacks

        assertEquals("XX", ss.popAt(2));
        assertEquals("Last", ss.pop());

        ss.pop(); // ZZ
        ss.pop(); // YY

        assertEquals("Z", ss.pop());

        ss.push("New");

        assertEquals("New", ss.peek());
    }

    @Test (expected = EmptyStackException.class)
    public void twoStackQueueTest() {
        TwoStackQueue<String> s = new TwoStackQueue<>();
        s.push("A")
                .push("B")
                .push("C")
                .push("D")
                .push("E");

        s.pop();
        s.pop();

        assertEquals("C", s.peek());
        assertEquals("C", s.pop());
        assertEquals("D", s.peek());
        assertEquals("D", s.pop());
        assertEquals("E", s.pop());

        s.pop(); // throws EmptyStackException
    }

    @Test
    public void sortedStackTest() {
        // sorted in ascending order
        SortedStack<Integer> ss = new SortedStack<>();
        ss.push(1);
        ss.push(3);
        ss.push(50);
        ss.push(7);
        ss.push(10);

        assertEquals(new Integer(1), ss.pop());
        assertEquals(new Integer(3), ss.pop());
        assertEquals(new Integer(7), ss.pop());
        assertEquals(new Integer(10), ss.pop());
        assertEquals(new Integer(50), ss.pop());
    }
}
