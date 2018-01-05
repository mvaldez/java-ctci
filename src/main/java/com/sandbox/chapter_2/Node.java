package com.sandbox.chapter_2;

/**
 * TODO: JAVADOC ME
 *
 * @author {@link "markvaldez@gmail.com"}
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> next() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Creates a new Node and appends
     * to the end of list
     *
     * @param data element to store
     * @return {@link Node} this instance
     */
    public Node<T> insertBack(T data) {
        Node<T> end = new Node<>(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
        return this;
    }

    public Node<T> insertFront(T data) {
        Node<T> n = new Node<>(this.getData());
        n.setNext(this.next());
        this.setNext(n);
        this.setData(data);
        return this;
    }

    /**
     * Insert {@link Node} to the end of list
     *
     * @param s source {@link Node}
     */
    public void insertNode(Node<T> s) {
        Node<T> n = this;
        while (n.next() != null) {
            n = n.next();
        }
        n.next = s;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node n = this;
        while (n.next != null) {
            sb.append(n.data);
            sb.append(", ");
            n = n.next;
        }

        sb.append(n.data); // last node
        sb.append("]");

        return sb.toString();
    }
}
