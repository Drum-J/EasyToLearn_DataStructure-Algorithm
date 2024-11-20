package sort;

import java.util.Comparator;

public class SelectionSort {
    public static <T> void selectionSort(T[] arr, Comparator<? super T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minValueIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare(arr[minValueIndex],arr[j]) > 0) {
                    minValueIndex = j;
                }
            }

            T temp = arr[i];
            arr[i] = arr[minValueIndex];
            arr[minValueIndex] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        selectionSort(arr,Comparable::compareTo);
    }
}
