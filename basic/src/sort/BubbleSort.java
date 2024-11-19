package sort;

import java.util.Comparator;

public class BubbleSort {
    public static <T> void bubbleSort(T[] arr, Comparator<? super T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < (arr.length - i - 1); j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        bubbleSort(arr, Comparable::compareTo);
    }
}
