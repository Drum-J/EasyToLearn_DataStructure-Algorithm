package sort;

public class QuickSort {

    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int left, int right) {
        if (left <= right) {
            int pivot = divide(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static <T extends Comparable<T>> int divide(T[] arr, int left, int right) {
        T pivot = arr[left];
        int leftStartIndex = left + 1;
        int rightStartIndex= right;

        while (leftStartIndex <= rightStartIndex) {
            while (leftStartIndex <= right && (pivot.compareTo(arr[leftStartIndex]) >= 0)) {
                leftStartIndex++;
            }

            while (rightStartIndex >= (left + 1) && (pivot.compareTo(arr[rightStartIndex]) <= 0)) {
                rightStartIndex--;
            }

            if (leftStartIndex <= rightStartIndex) {
                swap(arr, leftStartIndex, rightStartIndex);
            }
        }

        swap(arr, left, rightStartIndex);
        return rightStartIndex;
    }

    private static <T> void swap(T[] arr, int left, int right) {
        T temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
