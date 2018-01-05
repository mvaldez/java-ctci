package com.sandbox.chapter_2;

import java.util.Objects;

/**
 *
 * @author {@link "markvaldez@gmail.com"}
 */
public class LinkedLists {

    // 2.1 Remove Dups - no buffer
    // time complexity O(n^2)
    // space complexity O(1)
    public static <T> void removeDups(Node<T> head) {
        Node<T> n = head;

        while (n != null) {
            T tmp = n.getData();
            Node<T> runner = n;

            while (runner.next() != null) {
                if (Objects.equals(runner.next().getData(), tmp)) {
                    runner.setNext(runner.next().next());
                } else {
                    runner = runner.next(); // increment runner
                }
            }
            n = n.next(); // increment head
        }
    }

    // 2.2 Kth to Last - no buffer, zero based index
    // time complexity O(n)
    // space complexity O(1)
    public static <T> Node<T> fromLast(Node<T> head, int k) {
        Node<T> n = head;

        // iterate to find size
        int size = 0;
        while (n != null) {
            size++;
            n = n.next();
        }

        // validate k
        if (k > size - 1) {
            System.out.println("k exceeds size of list");
            return null;
        }

        // find k
        int index = size - k;
        n = head; // reset
        for (int i=0; i<index-1; i++) {
            n = n.next();
        }
        return n;
    }

    // 2.3 Delete Middle Node
    public static <T> void deleteMiddle(Node<T> n) {
        if ( n == null || n.next() == null ) return;

        n.setData(n.next().getData());
        n.setNext(n.next().next());
    }

    // 2.5 Sum Lists
    public static Node<Integer> sumList(Node<Integer> a, Node<Integer> b) {
        int sizeA = getSize(a);
        int sizeB = getSize(b);

        // fill with zeros if different sizes
        if (sizeA > sizeB) {
            paddList(b, sizeA-sizeB, 0);
        } else {
            paddList(a, sizeB-sizeA, 0);
        }

        // sum the lists
        Node<Integer> sum  = null;
        int carry = 0;
        while (a != null && b != null) {
            int val = a.getData() + b.getData() + carry;
            if (val > 10) {
                carry = 1;
                val = val - 10;
            } else {
                carry = 0;
            }
            if (sum == null) {
                sum = new Node<>(val);
            } else {
                sum.insertBack(val);
            }
            a = a.next();
            b = b.next();
        }
        return sum;
    }

    // 2.6 Palindrome
    public static <T> Boolean isPalindrome(Node<T> head) {
        Node<T> n = head;
        Node<T> reverse = null;
        while (n != null) {
            if (reverse == null) {
                reverse = new Node<>(n.getData());
            } else {
                reverse.insertFront(n.getData());
            }
            n = n.next();
        }

        if (reverse == null) return false;

        // TODO: this is a hack; should iterate over both lists again
        return head.toString().equals(reverse.toString());
    }

    // 2.7 Intersection
    public static <T> Boolean hasIntersection(Node<T> a, Node<T> b) {
        Node<T> lastA = getLastNode(a);
        Node<T> lastB = getLastNode(b);

        return lastA.equals(lastB);
    }

    // 2.8 Loop Detection
    public static <T> T hasCycle(Node<T> head) {
        Node<T> a = head;
        Node<T> b = head;

        while (a != null) {
            if (a.next() == null) return null;
            if (b.next() == null) return null;

            a = a.next();
            b = b.next().next();
            if (a.equals(b)) break;
        }

        if (a == null) return null;

        a = head; // reset one pointer

        // a should be k steps away from
        // entering loop and b should also
        // be k steps away from loop start
        while (!a.equals(b)) {
            a = a.next();
            b = b.next();
        }
        return b.getData();
    }

    public static <T> Node<T> getLastNode(Node<T> n) {
        Node<T> x = n;
        while (x.next() != null) {
            x = x.next();
        }
        return x;
    }

    public static <T> void paddList(Node<T> n, int count, T val) {
        for (int i=0; i<count; i++) {
            n.insertBack(val);
        }
    }

    public static <T> Node<T> removeNode(Node<T> head, int index) {
        Node<T> n = head;
        int current = 0;
        while (n.next() != null) {
            current++;
            if (current == index) {
                // n has not been incremented yet
                // bypass node
                n.setNext(n.next().next());
                break;
            }
            n = n.next();
        }
        return head;
    }

    public static <T> int getSize(Node<T> head) {
        Node<T> n = head;
        int size = 0;
        while (n.next() != null) {
            size++;
            n = n.next();
        }
        size++; // count last node
        return size;
    }
}
