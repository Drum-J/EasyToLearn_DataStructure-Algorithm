package sort;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        if (arr.length < 2) {
            return; // 배열 크기가 1 이하이면 정렬 필요 없음
        }

        int midIndex = (arr.length) / 2;

        T[] left = Arrays.copyOfRange(arr, 0, midIndex);
        T[] right = Arrays.copyOfRange(arr, midIndex, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static <T extends Comparable<? super T>> void merge(T[] arr, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        // 왼쪽과 오른쪽 배열의 원소를 비교하며 병합
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // 왼쪽 배열에 남은 원소 병합
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // 오른쪽 배열에 남은 원소 병합
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
