package sort;

import java.util.Comparator;

public class InsertionSort {
    public static <T> void insertSort(T[] arr, Comparator<? super T> comparator) {
        for (int i = 1; i < arr.length; i++) {
            T insertData = arr[i];

            int j;
            for (j = i - 1; j >= 0; j--) {
                if (comparator.compare(arr[j], insertData) > 0) {
                    arr[j + 1] = arr[j];
                } else break;
            }

            arr[j + 1] = insertData;
        }
    }

    public static <T extends Comparable<? super T>> void insertSort(T[] arr) {
        insertSort(arr, Comparable::compareTo);
    }
}
