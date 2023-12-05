package Bai1;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<LinkedBinaryTree.Node> {

        public static class Node<E> {
        private E element;
        private final Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node(E element) {
            this.element = element;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

            public void setLeft(Node left) {
                this.left = left;
            }

            public void setRight(Node right) {
                this.right = right;
            }

            public E getElement() {
            return element;
        }
    }

    private Node root;
    private int size;

    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    public void addRoot(E element) {
        if (root != null) {
            System.out.println("Error! Can't add root");
            return;
        }
        root = new Node(element, null, null, null);
        size++;
    }

    public void addLeft(Node p, E element) {
        if (p == null) {
            System.out.println("There is no parent");
            return;
        }
        if (p.left != null) {
            System.out.println("There already have left!");
        } else {
            p.left = new Node(element, p, null, null);
            size++;
        }
    }

    public void addRight(Node p, E element) {
        if (p == null) {
            System.out.println("There is no parent");
            return;
        }
        if (p.right != null) {
            System.out.println("There already have right!");
        } else {
            p.right = new Node(element, p, null, null);
            size++;
        }
    }

    public void set(Node p, E element) {
        if (p == null) {
            System.out.println("This position doesn't exist");
            return;
        }
        p.element = element;
    }

    @Override
    public Node root() {
        if (isEmpty()) {
            System.out.println("There is no root!");
            return null;
        }
        return this.root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(Node p) {
        int count = 0;
        if (p == null) {
            System.out.print("This node is null");
            return -1;
        }
        if (p.right != null) {count++;}
        if (p.left != null) {count++;}
        return count;
    }

    @Override
    public Node parent(Node p) {
        if (p == null) {
            System.out.println("This node is null");
            return null;
        }
        return p.parent;
    }

    @Override
    public Node left(Node p) {
        if (p == null) {
            System.out.println("This node is null");
            return null;
        }
        return p.left;
    }

    @Override
    public Node right(Node p) {
        if (p == null) {
            System.out.println("This node is null");
            return null;
        }
        return p.right;
    }

    @Override
    public Node sibling(Node p) {
        if (p == null) {
            System.out.println("This node is null");
            return null;
        }
        if (p == p.parent.left && p.parent.right != null) {return p.parent.right;}
        if (p == p.parent.right && p.parent.left != null) {return p.parent.left;}
        return null;
    }

    private Formatter fmt = null;
    private final File file = new File("Result.txt");

    private void printTree(Node p, int height) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
            fmt = new Formatter("Result.txt");
        }

        if (p == null) {return;}
        printTree(right(p), height + 1);
        for (int i = 0; i < height; i++) {
            System.out.print("     ");
            fmt.format("     ");
        }
        System.out.println(p.element);
        fmt.format(p.element + "\n");
        printTree(left(p), height + 1);
    }

    private void printResult() {
        try {
            if (file.exists()) {
                file.delete();
            }
            printTree(root, 0);
            fmt.flush();
            fmt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isLeaf(Node p) {
        return this.numChildren(p) == 0;
    }

    public int depth(Node p) {
        if (p == null) return -1;
        if (isLeaf(p)) return 0;
        return 1 + Math.max(depth(left(p)), depth((right(p))));
    }

    @Override
    public String toString() {
        System.out.println("Here is your binary tree: ");
        printResult();
        return "";
    }
}
