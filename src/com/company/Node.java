package com.company;

class Node {
    Profile p;
    Node left, right;

    public Node(Profile item) {
        p = item;
        left = right = null;
    }
}