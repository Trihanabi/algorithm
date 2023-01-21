import java.util.ArrayList;
import java.util.Collections;


// class for sort
public class CustomSort {
//    Quick sort
//    1. use a pivot to swap smaller number in right and bigger number in left.
//    2. get pivot position.
//    3. use this position to quicksort part before and after it.
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, 0, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        // use first element as pivot
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
//    Merge sort
//    1. divide array into smallest array
//    2. conbine them
//        2.1 build aux sort
//        2.2 use for loop to sort 2 halves
    public static void mergeSort(int[] arr, int[] aux, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, aux, left, mid);
            mergeSort(arr, aux, mid+1, right);
            merge(arr, aux, left, mid, right);
        }
    }

//    to merge two arrays
    public static void merge(int[] arr, int[] aux, int left, int mid, int right) {
        // low and high are indexes of aux
        int low = left, high = mid + 1;

        // build aux array
        for (int k = left; k <= right; k++) {
            aux[k] = arr[k];
        }

        for (int i = left; i <= right; i++) {
            // four cases: to the end of two arrays and two comparison cases
            if (low > mid)                  arr[i] = aux[high++];
            else if (high > right)          arr[i] = aux[low++];
            else if (aux[low] < aux[high])  arr[i] = aux[low++];
            else                            arr[i] = aux[high++];
        }
    }
//    Bucket sort
//    1. build buckets and add elements to buckets
//    2. use collection sort to sort bucket
//    3. combine buckets

    public static void bucketSort(int[] arr, int n) {
        if (n <= 0)
            return;

        // 1
        ArrayList<Integer>[] bucket = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            bucket[index].add(arr[i]);
        }

        // 2
        for (int i = 0; i < n; i++) {
            Collections.sort(bucket[i]);
        }

        // 3
        int arrIndex = 0;
        for (ArrayList l: bucket) {
            for (int j = 0; j < l.size(); j++){
                arr[arrIndex++] = (int) l.get(j);
            }
        }

    }
//    Bubble sort
//    1. swapped: if it needs swap in the iterate, if false means array finishes sort.
    public static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
//    Insertion sort
//    1. use nest for loop: 1st decide insert interval, 2nd for insert
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j-1] > arr[j]; j--) {
                swap(arr, j-1, j);
            }
        }
    }
//    Selection sort
//    1. min: the index of the smallest element in the interval
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
