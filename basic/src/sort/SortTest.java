package sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 2, 3, 1};

        BubbleSort.bubbleSort(arr);

        System.out.println("arr = " + Arrays.toString(arr));
    }
}
