package com.ssj.ds.tree.binarysearchtree;

import com.ssj.ds.tree.Node;

public class BinarySearchTree {

    Node<Integer> root;

    public void add(int value) {
        if (this.root == null)
            this.root = new Node<Integer>(value);
        else if (this.root.getValue() > value)
            addNode(value, this.root.getLeft());
        else
            addNode(value, this.root.getRight());
    }

    public Node<Integer> addNode(int value, Node<Integer> current) {
        if (current == null)
            return new Node<>(value);
        if (current.getValue() > value)
            return addNode(value, current.getLeft());
        else
            return addNode(value, current.getRight());
    }

    public Node search(int value, Node<Integer> current) {
        if (current == null || current.getValue() == value)
            return current;
        if (current.getValue() > value)
            return search(value, current.getLeft());
        else
            return search(value, current.getRight());
    }
}
