package Bai2;

import java.util.Objects;

public class SearchBinaryTree<E extends Comparable<E>> {

    public static class Node<E> {

        protected Node<E> left;
        protected Node<E> right;

        protected Node<E> parent;
        protected E element;

        public Node(E element) {
            this.element = element;
            this.right = null;
            this.left = null;
            this.parent = null;
        }
        public E getElement() {
            return element;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }
    }

    protected Node<E> root;
    protected int size;

    public SearchBinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public Node<E> insert(Node<E> node, E element) {
        if (element == null) {
            System.out.println("Element is null!");
            return null;
        } else if (node == null) {
            node = new Node<>(element);
        } else if (node.element.compareTo(element) > 0) {
            node.left = insert(node.left, element);

            if (node.left != null) {
                node.left.parent = node;
            }
        } else if (node.element.compareTo(element) < 0) {
            node.right = insert(node.right, element);

            if (node.right != null) {
                node.right.parent = node.right;
            }
        } else {
            System.out.println("This binary search tree doesn't allow duplicate element");
            return null;
        }
        return node;
    }

    public void insert(E element) {
        if (isEmpty()) {
            this.root = new Node<>(element);
        } else {
            insert(this.root, element);
        }
        size++;
    }

    public Node<E> search(Node<E> node, E element) {
        if (node == null || element == null) {
            System.out.println("Node or element is null");
            return null;
        } else if (node.element.equals(element)) {
            return node;
        } else if (node.element.compareTo(element) < 0) {
            return search(node.right, element);
        } else if (node.element.compareTo(element) > 0) {
            return search(node.left, element);
        } else {
            return null;
        }
    }

    public Node<E> search(E element) {
        return search(root, element);
    }

    private Node<E> findMin(Node<E> root) {
        if (isEmpty()) {
            System.out.println("Empty tree!");
            return null;
        } else {
            while (root.left != null) {
                root = root.left;
            }
        }
        return root;
    }

    public E findMin() {
        return Objects.requireNonNull(findMin(this.root)).getElement();
    }

    public Node<E> delete(Node<E> node, E element) {
        if (node == null || element == null) {
            System.out.println("Node or element is null");
            return null;
        }
        if (node.element.compareTo(element) > 0) {
            node.left = delete(node.left, element);
            if (root.left != null)
                root.left.parent = root;
            return node;
        } else if (node.element.compareTo(element) < 0) {
            node.right = delete(node.right, element);
            if (root.right != null)
                root.right.parent = root;
            return node;
        } else if (node.element.equals(element) && node.left == null && node.right != null) {
            return node.right;
        } else if (node.element.equals(element) && node.left != null && node.right == null) {
            return node.left;
        } else if (node.element.equals(element) && node.left != null && node.right != null) {
            Node<E> successor = findMin(node.right);
            assert successor != null;
            node.element = successor.element;
            node.right = delete(node.right, node.element);
            if (node.right != null) {
                node.right.parent = node;
            }
            return node;
        } else if (node.element.equals(element) && node.left == null && node.right == null) {
            return null;
        } else {
            return null;
        }
    }

    public void delete(E element) {
        delete(root, element);
        size--;
    }

    private boolean isEmpty() {
        return this.root == null && this.size == 0;
    }

    private void printTree(Node<E> currentNode, int depth) {
        if (currentNode == null) return;

        printTree(currentNode.right, depth + 1);
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(currentNode.element);
        printTree(currentNode.left, depth + 1);
    }

    public long getTime(E element) {
        long start = System.nanoTime();
        Node<E> node = search(element);
        long end = System.nanoTime();
        if (node == null) {
            System.out.printf("Can't find this element!\nTime: %.3f ms\n", (end - start) / 1000000.0);
        } else {
            System.out.printf("Find the element at position %s!\nTime: %.3f ms\n",node, (end - start) / 1000000.0);
        }
        return (long) ((end - start) / 1000000.0);
    }

    @Override
    public String toString() {
        printTree(root, 0);
        return "";
    }
}