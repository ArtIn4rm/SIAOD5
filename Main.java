package com.company;

public class Main {

    public static void main(String[] args){
        StrTree<String> treeStr = new StrTree<>();
        treeStr.insert(76, "a");
        treeStr.insert(21, "b");
        treeStr.insert(82, "c");
        treeStr.insert(12, "d");
        treeStr.insert(42, "e");
        treeStr.insert(25, "f");
        treeStr.insert(64, "g");
        treeStr.insert(78, "h");
        treeStr.insert(88, "j");
        treeStr.insert(97, "k");

        treeStr.remove(21);

        treeStr.printInOrder();

        SymTree<String> treeSym = new SymTree<>();
        treeSym.insert(76, "a");
        treeSym.insert(21, "b");
        treeSym.insert(82, "c");
        treeSym.insert(12, "d");
        treeSym.insert(42, "e");
        treeSym.insert(25, "f");
        treeSym.insert(64, "g");
        treeSym.insert(78, "h");
        treeSym.insert(88, "j");
        treeSym.insert(97, "k");

        treeSym.remove(21);

        treeSym.printInOrder();

        Tree<String> tree = new Tree<>(76, "a");
        tree.insert(tree.root,21, "b");
        tree.insert(tree.root,82, "c");
        tree.insert(tree.root,12, "d");
        tree.insert(tree.root,42, "e");
        tree.insert(tree.root,25, "f");
        tree.insert(tree.root,64, "g");
        tree.insert(tree.root,78, "h");
        tree.insert(tree.root,88, "j");
        tree.insert(tree.root,97, "k");

        tree.remove(tree.root,21);

        tree.printPostOrder(tree.root);
        System.out.println(tree.search(tree.root, 78));
        System.out.println(tree.search(tree.root, 11));
    }
}
