package Bai1;

import java.io.File;
import java.util.Formatter;
import java.util.Objects;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<Integer> {

    private E[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    public void setRoot(E element) {
        if (this.array[1] == null) {
            array[1] = element;
            n++;
        } else {
            this.array[1] = element;
        }
    }

    public void setLeft(int p, E element) {
        if (invalid(p)) {
            if (p * 2 >= array.length) {
                expand();
            }
            if (array[p * 2] == null) {
                array[p * 2] = element;
                n++;
            } else {
                array[p * 2] = element;
            }
        }
    }

    public void setRight(int p, E element) {
        if (invalid(p)) {
            if (p * 2 + 1>= array.length) {
                expand();
            }
            if (array[p * 2 + 1] == null) {
                array[p * 2 + 1] = element;
                n++;
            } else {
                array[p * 2] = element;
            }
        }
    }

    @Override
    public Integer root() {
        if (isEmpty()) {
            System.out.println("There is no root.");
            return null;
        }
        return 1;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(Integer p) {
        int countChild = 0;
        if (invalid(p)) {
            if (array[left(p)] != null) {
                countChild++;
            }
            if (array[right(p)] != null) {
                countChild++;
            }
        }
        return countChild;
    }

    @Override
    public Integer parent(Integer p) {
        if (invalid(p)) {
            if (p.equals(root())) {
                System.out.println("There is no parent of root!");
                return null;
            }
        }
        return p / 2;
    }

    @Override
    public Integer left(Integer p) {
        if (invalid(p)) {
            return 2 * p;
        } else {
            return null;
        }
    }

    @Override
    public Integer right(Integer p) {
        if (invalid(p)) {
            return 2 * p + 1;
        } else {
            return null;
        }
    }

    @Override
    public Integer sibling(Integer p) {
        if (invalid(p)) {
            if (p == 1) {
                System.out.println("Root has no sibling;");
                return -1;
            }
            int parent = parent(p);
            if (Objects.equals(left(parent), p) && array[right(parent)] != null) {return right(parent);}
            if (Objects.equals(right(parent), p) && array[left(parent)] != null) {return left(parent);}
        }
        return null;
    }

    private void expand() {
        E[] newArr = (E[]) new Object[this.defaultSize * 2];
        System.arraycopy(array, 0, newArr, 0, array.length);
        this.defaultSize = this.defaultSize * 2;
        array = newArr;
    }

    private boolean invalid(int p) {
        if (p <= 0 || p >= array.length) {
            System.out.println("Out of index!");
            return false;
        }
        if (array[p] == null) {
            System.out.println("There is no parent!");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        System.out.println("Here is your binary tree: ");
        printResult();
        return " ";
    }

    private Formatter formatter = null;
    private File file = new File("Result.txt");
    private void printTree(int currentIndex, int high) {
        try {
            if (!file.exists()) {
                file.createNewFile();
                formatter = new Formatter("Result.txt");
            }
            if (array[currentIndex] == null) {
                return;
            }
            printTree(right(currentIndex), high + 1);
            for (int i = 0; i < high; i++) {
                System.out.print("    ");
                formatter.format("    ");
            }
            System.out.println(array[currentIndex]);
            formatter.format(array[currentIndex]+ "\n");
            printTree(left(currentIndex), high + 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printResult() {
        if (file.exists()) {
            file.delete();
        }
        printTree(1, 0);
        formatter.flush();
        formatter.close();
    }

}
