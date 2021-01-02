package com.ssj.ds.tree;

public class Node<T> {

    Node<T> left;
    Node<T> right;

    T value;

    public Node(T value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
