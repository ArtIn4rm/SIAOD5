package com.company;

class Node<V>{
    int key;
    V value;
    Node<V> left;
    Node<V> right;
    boolean hasLeftThread;
    boolean hasRightThread;

    Node(int key, V value){
        this.key = key;
        this.value = value;
    }

    Node(){
        this.key = 0;
        this.value = null;
        this.left = null;
        this.right = null;
        this.hasLeftThread = false;
        this.hasRightThread = false;
    }

}
