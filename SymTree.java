package com.company;

class SymTree<V>{

    private Node<V> root;

    void printInOrder() {
        Node<V> current = leftmost(root);
        while (current != null) {
            System.out.println(current.key + ", " + current.value);
            if (current.hasRightThread) {
                current = current.right;
            } else {
                current = leftmost(current.right);
            }
        }
    }

    private Node<V> leftmost(Node<V> current) {
        while (current != null && current.left != null && !current.hasLeftThread) {
            current = current.left;
        }
        return current;
    }

    void insert(int key, V value) {
        Node<V> parent = null;
        Node<V> current = root;
        while (current != null) {
            parent = current;
            if (key == current.key) {
                current.value = value;
                return;
            } else if (key < current.key) {
                if (!current.hasLeftThread) {
                    current = current.left;
                } else {
                    break;
                }
            } else {
                if (!current.hasRightThread) {
                    current = current.right;
                } else {
                    break;
                }
            }
        }
        Node<V> node = new Node<>(key, value);
        node.hasLeftThread = true;
        node.hasRightThread = true;
        if (parent == null) {
            root = node;
        } else if (key < parent.key) {
            node.left = parent.left;
            node.right = parent;
            parent.hasLeftThread = false;
            parent.left = node;
        } else {
            node.left = parent;
            node.right = parent.right;
            parent.hasRightThread = false;
            parent.right = node;
        }
    }


    void remove(int key) {
        Node<V> parent = null;
        Node<V> current = root;
        boolean found = false;
        while (current != null) {
            if (key == current.key) {
                found = true;
                break;
            }
            parent = current;
            if (key < current.key) {
                if (!current.hasLeftThread) {
                    current = current.left;
                } else {
                    break;
                }
            } else {
                if (!current.hasRightThread) {
                    current = current.right;
                } else {
                    break;
                }
            }
        }
        if (found) {
            if (!current.hasLeftThread && !current.hasRightThread) {
                root = caseC(root, current);
            } else if (!current.hasLeftThread) {
                root = caseB(root, parent, current);
            } else if (!current.hasRightThread) {
                root = caseB(root, parent, current);
            } else {
                root = caseA(root, parent, current);
            }
        }
    }


    private Node<V> caseA(Node<V> root, final Node<V> parent, final Node<V> current) {
        if (parent == null) {
            root = null;
        } else if (current == parent.left) {
            parent.hasLeftThread = true;
            parent.left = current.left;
        } else {
            parent.hasRightThread = true;
            parent.right = current.right;
        }
        return root;
    }

    private Node<V> caseB(Node<V> root, final Node<V> parent, final Node<V> current) {
        Node<V> child;
        if (!current.hasLeftThread) {
            child = current.left;
        } else {
            child = current.right;
        }
        if (parent == null) {
            root = child;
        } else if (current == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        Node next = findNext(current);
        Node prev = findPrev(current);
        if (!current.hasLeftThread) {
            prev.right = next;
        } else {
            next.left = prev;
        }
        return root;
    }

    private Node<V> findNext(Node<V> current) {
        if (current.hasRightThread) {
            return current.right;
        }
        current = current.right;
        while (!current.hasLeftThread) {
            current = current.left;
        }
        return current;
    }


    private Node<V> findPrev(Node<V> current) {
        if (current.hasLeftThread) {
            return current.left;
        }
        current = current.left;
        while (!current.hasRightThread) {
            current = current.right;
        }
        return current;
    }

    private Node<V> caseC(Node<V> root, final Node<V> current) {
        Node<V> nextParent = current;
        Node<V> next = current.right;
        while (!next.hasLeftThread) {
            nextParent = next;
            next = next.left;
        }
        current.key = next.key;
        if (next.hasRightThread) {
            root = caseA(root, nextParent, next);
        } else {
            root = caseB(root, nextParent, next);
        }
        return root;
    }
}

