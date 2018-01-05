package com.sandbox.chapter_2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author {@link "markvaldez@gmail.com"}
 */
public class LinkedListsTest {
    @Test
    public void NodeTest() {
        final Node<Integer> head = new Node<>(1);
        head.insertBack(2)
                .insertBack(3)
                .insertBack(4)
                .insertBack(5);

        System.out.println(head);

        assertEquals("[1, 2, 3, 4, 5]", head.toString());

        Node<String> front = new Node<>("a")
                .insertFront("b")
                .insertFront("c");
        front.insertFront("d");

        System.out.println(front);

        assertEquals("[d, c, b, a]", front.toString());
    }

    @Test
    public void hasCycleTest() {
        Node<String> cycle = new Node<>("C");
        Node<String> head = new Node<>("A")
                .insertBack("B");
        head.insertNode(cycle);
        head.insertBack("D")
                .insertBack("E");
        head.insertNode(cycle);

        assertEquals("C", LinkedLists.hasCycle(head));

        Node<String> noCycle = new Node<>("A")
                .insertBack("B")
                .insertBack("C");

        assertNull(LinkedLists.hasCycle(noCycle));
    }

    @Test
    public void hasIntersectionTest() {
        Node<String> x = new Node<String>("x");
        Node<String> a = new Node<>("a")
                .insertBack("b")
                .insertBack("X");
        a.insertNode(x);
        a.insertBack("d")
                .insertBack("e");

        Node<String> b = new Node<>("i")
                .insertBack("j");
        b.insertNode(x);
        b.insertBack("k")
                .insertBack("l")
                .insertBack("m");

        assertTrue(LinkedLists.hasIntersection(a, b));

        Node<String> c = new Node<>("i")
                .insertBack("j")
                .insertBack("k")
                .insertBack("l")
                .insertBack("m");

        assertFalse(LinkedLists.hasIntersection(a, c));
    }

    @Test
    public void isPalindromeTest() {
        final Node<String> head = new Node<>("r")
                .insertBack("a")
                .insertBack("c")
                .insertBack("e")
                .insertBack("c")
                .insertBack("a")
                .insertBack("r");

        assertTrue(LinkedLists.isPalindrome(head));

        head.insertFront("x");

        assertFalse(LinkedLists.isPalindrome(head));
    }

    @Test
    public void sumListTest() {
        final Node<Integer> a = new Node<>(7)
                .insertBack(1)
                .insertBack(6);
        final Node<Integer> b = new Node<>(5)
                .insertBack(9)
                .insertBack(2);
        final Node<Integer> expected = new Node<>(2)
                .insertBack(1)
                .insertBack(9);
        final Node<Integer> sum = LinkedLists.sumList(a, b);
        assertEquals(expected.toString(), sum.toString());

        // test different sizes
        b.insertBack(9); // increase list size
        final Node<Integer> sum2 = LinkedLists.sumList(a, b);
        final Node<Integer> expected2 = new Node<>(2)
                .insertBack(1)
                .insertBack(9)
                .insertBack(9);
        assertEquals(expected2.toString(), sum2.toString());
    }

    @Test
    public void deleteMiddleTest() {
        final Node<String> ll = new Node<>("a")
                .insertBack("b");

        // get a reference to the node we are about
        // to delete
        Node<String> cNode = new Node<>("c");
        ll.insertNode(cNode);

        ll.insertBack("d")
                .insertBack("e")
                .insertBack("f");

        final Node<String> expected = new Node<>("a")
                .insertBack("b")
                .insertBack("d")
                .insertBack("e")
                .insertBack("f");

        // delete c node from list
        LinkedLists.deleteMiddle(cNode);
        assertEquals(expected.toString(), ll.toString());

        // add c to the end; create new c node
        // Bonus: Why did I recreate c Node?
        cNode = new Node<>("c");
        ll.insertNode(cNode);
        LinkedLists.deleteMiddle(cNode);

        // verify that the end cannot be deleted
        expected.insertBack("c");
        assertEquals(expected.toString(), ll.toString());

        // Bonus: What happens if I delete the first node?
        LinkedLists.deleteMiddle(ll);
    }

    @Test
    public void getSizeTest() {
        final Node<Integer> head = new Node<>(1);
        head.insertBack(2)
                .insertBack(3)
                .insertBack(4)
                .insertBack(5);

        assertEquals(5, LinkedLists.getSize(head));

        head.insertBack(6);

        assertEquals(6, LinkedLists.getSize(head));
    }

    @Test
    public void removeDupsTest() {
        final Node<Integer> head0 = new Node<>(1);
        head0.insertBack(2)
                .insertBack(3)
                .insertBack(2)
                .insertBack(1)
                .insertBack(4);

        LinkedLists.removeDups(head0);
        assertEquals("[1, 2, 3, 4]", head0.toString());

        final Node<Integer> head1 = new Node<>(2);
        head1.insertBack(2)
                .insertBack(2)
                .insertBack(2)
                .insertBack(2)
                .insertBack(2);
        LinkedLists.removeDups(head1);
        assertEquals("[2]", head1.toString());

        final Node<Integer> head2 = new Node<>(2);
        LinkedLists.removeDups(head2);
        assertEquals("[2]", head2.toString());

        final Node<Integer> head3 = new Node<>(1);
        head3.insertBack(2)
                .insertBack(3)
                .insertBack(4)
                .insertBack(5)
                .insertBack(1);

        LinkedLists.removeDups(head3);
        assertEquals("[1, 2, 3, 4, 5]", head3.toString());

        final Node<Integer> head4 = new Node<>(1);
        head4.insertBack(2)
                .insertBack(3)
                .insertBack(4)
                .insertBack(5)
                .insertBack(6)
                .insertBack(7)
                .insertBack(8)
                .insertBack(9);

        LinkedLists.removeDups(head4);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", head4.toString());
    }

    @Test
    public void fromLastTest() {
        final Node<Integer> head = new Node<>(1);
        head.insertBack(2)
                .insertBack(3)
                .insertBack(4)
                .insertBack(5)
                .insertBack(6)
                .insertBack(7)
                .insertBack(8)
                .insertBack(9);

        assertEquals(new Integer(9), LinkedLists.fromLast(head, 0).getData());
        assertEquals(new Integer(8), LinkedLists.fromLast(head, 1).getData());
        assertEquals(new Integer(7), LinkedLists.fromLast(head, 2).getData());
        assertEquals(new Integer(6), LinkedLists.fromLast(head, 3).getData());
        assertEquals(new Integer(5), LinkedLists.fromLast(head, 4).getData());
        assertEquals(new Integer(4), LinkedLists.fromLast(head, 5).getData());
        assertEquals(new Integer(3), LinkedLists.fromLast(head, 6).getData());
        assertEquals(new Integer(2), LinkedLists.fromLast(head, 7).getData());
        assertEquals(new Integer(1), LinkedLists.fromLast(head, 8).getData());
        Assert.assertNull(LinkedLists.fromLast(head, 9));
    }

}