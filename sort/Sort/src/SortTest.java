public class SortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 2, 7, 6, 8, 1, 1, -8};
        System.out.println("Quick sort: ");
        System.out.println("Array before sort: ");
        printArr(arr);

        CustomSort.quickSort(arr, 0, arr.length-1);
        System.out.println("Array after sort: ");
        printArr(arr);

        arr = new int[]{5, 4, 2, 7, 6, 8, 1, 1, -8};
        System.out.println("\nMerge sort: ");
        System.out.println("Array before sort: ");
        printArr(arr);
        int[] aux = new int[arr.length];
        System.arraycopy(arr, 0, aux, 0, arr.length);
        CustomSort.mergeSort(arr, aux, 0, arr.length-1);
        System.out.println("Array after sort: ");
        printArr(arr);
        printArr(aux);

        // for big numbers, bucket sort is More effective
        arr = new int[]{5, 4, 2, 7, 6, 8, 1, 1, 8};
        System.out.println("\nBucket sort: ");
        System.out.println("Array before sort: ");
        printArr(arr);
        CustomSort.bucketSort(arr, 10 );
        System.out.println("Array after sort: ");
        printArr(arr);



        arr = new int[]{5, 4, 2, 7, 6, 8, 1, 1, -8};
        System.out.println("\nInsertion sort: ");
        System.out.println("Array before sort: ");
        printArr(arr);
        CustomSort.insertionSort(arr);
        System.out.println("Array after sort: ");
        printArr(arr);


        arr = new int[]{5, 4, 2, 7, 6, 8, 1, 1, -8};
        System.out.println("\nSelection sort: ");
        System.out.println("Array before sort: ");
        printArr(arr);
        CustomSort.selectionSort(arr);
        System.out.println("Array after sort: ");
        printArr(arr);


        arr = new int[]{5, 4, 2, 7, 6, 8, 1, 1, -8};
        System.out.println("\nBubble sort: ");
        System.out.println("Array before sort: ");
        printArr(arr);
        CustomSort.bubbleSort(arr);
        System.out.println("Array after sort: ");
        printArr(arr);


    }

    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();

    }
}
