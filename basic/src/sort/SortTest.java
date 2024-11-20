package sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 2, 1, 3};

        //BubbleSort.bubbleSort(arr);
        SelectionSort.selectionSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
