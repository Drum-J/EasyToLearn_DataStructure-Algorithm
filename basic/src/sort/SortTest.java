package sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Integer[] arr = {3, 5, 2, 4, 1, 7, 8, 6};

        //BubbleSort.bubbleSort(arr);
        //SelectionSort.selectionSort(arr);
        //InsertionSort.insertSort(arr);
        MergeSort.mergeSort(arr); // O(n log n)

        System.out.println("arr = " + Arrays.toString(arr));
    }
}
