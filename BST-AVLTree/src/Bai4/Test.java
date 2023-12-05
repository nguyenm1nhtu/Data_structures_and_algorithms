package Bai4;

public class Test {

    public static void main(String[] args) {
        BinaryTree_2D<Integer> tree = new BinaryTree_2D<>();

        tree.insert(new Integer[]{3, 6});
        tree.insert(new Integer[]{19, 18});
        tree.insert(new Integer[]{5, 17});
        tree.insert(new Integer[]{7, 2});
        tree.insert(new Integer[]{9, 5});
        tree.insert(new Integer[]{8, 1});

        System.out.println("Print Tree before operations:");
        tree.rangeSearch(new Integer[]{0, 0}, new Integer[]{20, 20});

        Integer[] pointToDelete = {7, 2};
        tree.delete(pointToDelete);
        System.out.println("Deleted point: (" + pointToDelete[0] + ", " + pointToDelete[1] + ")");

        System.out.println("Print Tree after deleting:");
        tree.rangeSearch(new Integer[]{0, 0}, new Integer[]{20, 20});

        Integer[] newPoint = {4, 4};
        tree.insert(newPoint);
        System.out.println("Inserted new point: (" + newPoint[0] + ", " + newPoint[1] + ")");

        System.out.println("Print Tree after inserting new point:");
        tree.rangeSearch(new Integer[]{0, 0}, new Integer[]{20, 20});

        System.out.println("Min Point: " + tree.findMin());
    }
}
