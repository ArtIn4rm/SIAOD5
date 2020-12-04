package com.company;

class Tree<V>{
    Node<V> root;

    Tree(){
        root = new Node<>();
    }

    Tree(int key, V value){
        root = new Node<>();
        root.key = key;
        root.value = value;
    }

    Node<V> insert(Node<V>  current, int key, V value){
        if(root.value == null){
            root.key = key;
            root.value = value;
        }
        if(current == null){
            current = new Node<>();
            current.key = key;
            current.value = value;
            return current;
        }
        if(key < current.key){
            current.left = insert(current.left, key, value);
        } else if(key > current.key){
            current.right = insert(current.right, key, value);
        } else {
            current.value = value;
        }
        return current;
    }

    boolean search(Node<V> current, int key){
        if(current == null){
            return false;
        }
        if(key == current.key){
            return true;
        }
        if(key < current.key){
            return search(current.left, key);
        }
        return search(current.right, key);
    }

    Node<V> remove(Node<V> current, int key){
        if(current == null){
            return null;
        }
        if(key < current.key){
            current.left = remove(current.left, key);
        } else if(key > current.key){
            current.right = remove(current.right, key);
        } else {
            if(current.left == null){
                return current.right;
            }
            if(current.right == null){
                return current.left;
            }
            current.key = min(current.right);
            current.right = remove(current.right, current.key);
        }
        return current;
    }

    private int min(Node<V> current){
        int min = 0;
        while(current.left != null){
            min = current.left.key;
            current = current.left;
        }
        return min;
    }

    private int max(Node<V> current){
        int max = 0;
        while(current.right != null){
            max = current.right.key;
            current = current.right;
        }
        return max;
    }

    void printPreOrder(Node<V> current){
        if(current == null) return;
        System.out.println(current.key + ", " + current.value);
        printPreOrder(current.left);
        printPreOrder(current.right);
    }

    void printInOrder(Node<V> current){
        if(current == null)  { return;}
        printInOrder(current.left);
        System.out.println(current.key + ", " + current.value);
        printInOrder(current.right);
    }

    void printPostOrder(Node<V> current){
        if(current == null) return;
        printPostOrder(current.left);
        printPostOrder(current.right);
        System.out.println(current.key + ", " + current.value);
    }
}
