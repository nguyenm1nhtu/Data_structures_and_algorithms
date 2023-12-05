package Bai4;

public class BinaryTree_2D<E extends Comparable<E>> {

    protected static class Node<E> {
        private E[] point;
        private Node<E> left;
        private Node<E> right;

        public Node(E[] point) {
            this.point = point;
            this.left = null;
            this.right = null;
        }
    }

    private Node<E> root;

    public BinaryTree_2D() {
        this.root = null;
    }

    private Node<E> insert(Node<E> node, E[] point, int depth) {
        if (point == null || point.length != 2) {
            System.out.println("Invalid Point!");
            return node;
        }

        int axis = depth % 2;
        if (node == null) {
            return new Node<>(point);
        } else if (point[axis].compareTo(node.point[axis]) < 0) {
            node.left = insert(node.left, point, depth + 1);
        } else if (point[axis].compareTo(node.point[axis]) > 0) {
            node.right = insert(node.right, point, depth + 1);
        } else {
            System.out.println("This tree doesn't allow duplicate point");
            return null;
        }
        return node;
    }

    public void insert(E[] point) {
        if (this.root == null) {
            this.root = new Node<>(point);
        } else {
            insert(root, point, 0);
        }
    }

    private Node<E> delete(Node<E> node, E[] point, int depth) {
        if (point == null || point.length != 2) {
            System.out.println("Invalid Point!");
            return node;
        }

        int axis = depth % 2;
        if (root == null) {
            return null;
        } else if (point[axis].compareTo(node.point[axis]) < 0) {
            node.left = delete(node.left, point, depth + 1);
            return node;
        } else if (point[axis].compareTo(node.point[axis]) > 0) {
            node.right = delete(node.right, point, depth + 1);
            return node;
        } else if (point[axis].equals(node.point[axis]) && node.left == null && node.right != null) {
            return node.right;
        } else if (point[axis].equals(node.point[axis]) && node.left != null && node.right == null) {
            return node.left;
        } else if (point[axis].equals(node.point[axis]) && node.left != null && node.right != null) {
            node.point = findMin(node.right);
            node.right = delete(node.right, node.point, depth + 1);
            return node;
        } else {
            return null;
        }
    }

    public void delete(E[] point) {
        root = delete(root, point, 0);
    }

    private E[] findMin(Node<E> node) {
        if (node == null) return null;
        while (root.left != null) {
            node = node.left;
        }
        return node.point;
    }

    public String findMin() {
        StringBuilder point = new StringBuilder();
        E[] pointMin = findMin(root);
        point.append("(").append(pointMin[0]).append(",\s").append(pointMin[1]).append(")");
        return point.toString();
    }

    private void rangeSearch(Node<E> node, E[] low, E[] high, int depth) {
        if (node == null) {
            return;
        }

        int axis = depth % 2;

        if (node.point[axis].compareTo(low[axis]) >= 0
                && node.point[axis].compareTo(high[axis]) <= 0
                && node.point[1 - axis].compareTo(low[1 - axis]) >= 0
                && node.point[1 - axis].compareTo(high[1 - axis]) <= 0) {
            System.out.println("(" + node.point[0] + ", " + node.point[1] + ")");
        }

        if (node.point[axis].compareTo(low[axis]) >= 0) {
            rangeSearch(node.left, low, high, depth + 1);
        }

        if (node.point[axis].compareTo(high[axis]) <= 0) {
            rangeSearch(node.right, low, high, depth + 1);
        }
    }

    public void rangeSearch(E[] low, E[] high) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        rangeSearch(this.root, low, high, 0);
    }
}
