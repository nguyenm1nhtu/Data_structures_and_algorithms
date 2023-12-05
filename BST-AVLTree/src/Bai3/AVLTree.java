package Bai3;

import Bai2.SearchBinaryTree;

public class AVLTree<E extends Comparable<E>> extends SearchBinaryTree<E> {

    @Override
    public void insert(E element) {
        super.insert(element);
        if (root.getParent() != null) {
            root = root.getParent();
            root.setParent(null);
        }
    }

    @Override
    public void delete(E element) {
        super.delete(element);
        if (root.getParent() != null) {
            root = root.getParent();
            root.setParent(null);
        }
    }

    @Override
    public E findMin() {
        return super.findMin();
    }

    @Override
    public Node<E> insert(Node<E> node, E element) {
        node = super.insert(node, element);
        return balance(node);
    }

    public Node<E> delete(Node<E> node, E element) {
        node = super.delete(node, element);
        if (node == null) {
            return null;
        }
        return balance(node);
    }

    private Node<E> rotateLeft(Node<E> node) {
        Node<E> rightNode = node.getRight();

        if (rightNode != null) {
            node.setRight(rightNode.getLeft());
            if (node.getRight() != null) {
                node.getRight().setParent(node);
            }
            rightNode.setLeft(node);
            rightNode.getLeft().setParent(rightNode);
            return rightNode;
        }
        return node;
    }

    private Node<E> rotateRight(Node<E> node) {
        Node<E> leftNode = node.getLeft();

        if (leftNode != null) {
          node.setLeft(leftNode.getRight());
          if (node.getLeft() != null) {
              node.getLeft().setParent(node);
          }
          leftNode.setRight(node);
          leftNode.getRight().setParent(leftNode);
          return leftNode;
        }
        return node;
    }

     private int getHeight(Node<E> root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = 0;
            if (root.getLeft() != null) {
                leftHeight = getHeight(root.getLeft());
            }

            int rightHeight = 0;
            if (root.getRight() != null) {
                rightHeight = getHeight(root.getRight());
            }

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    private int balanceFactor(Node<E> node) {
        if (node == null) return 0;
        return getHeight(node.getRight()) - getHeight(node.getLeft());
    }

    private Node<E> balance(Node<E> node) {
        int balance = balanceFactor(node);

        if (balance != 0) {
            if (balance > 1 && node.getRight() != null && balanceFactor(node.getRight()) >= 0) {
                node = rotateLeft(node);
            } else if (balance > 1 && node.getRight() != null && balanceFactor(node.getRight()) < 0) {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            } else if (balance < -1 && node.getLeft() != null && balanceFactor(node.getLeft()) <= 0) {
                node = rotateRight(node);
            } else if (balance < -1 && node.getLeft() != null && balanceFactor(node.getLeft()) > 0) {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }
        return node;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
