package binarytree;

/**
 * 이진 탐색 알고리즘
 * 쉽게 구현하기 위해 int 만 사용하도록 했음
 */
public class BinarySearch {

    public static Integer search(int[] array, int target, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (target > array[mid]) {
            return search(array, target, mid + 1, end);
        } else {
            return search(array, target, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer index = BinarySearch.search(array, 3, 0, array.length - 1);
        System.out.println("index = " + index);
    }
}
