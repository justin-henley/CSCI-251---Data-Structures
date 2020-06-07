/*
        CSCI 251 VA DATA STRUCTURES SPRING 2020
        Project 1
        Created by: Justin Henley
        Email:      jahenley@mail.fhsu.edu
        Version:    2020-06-07

        This class implements the following sorting algorithms for arrays:
            Insert Sort
            Select Sort
            Quick Sort
            Merge Sort

        Can be tested for speed using CSCI251ProjOne.java
 */

// TODO function descriptions, preconditions, postconditions

public class MySort {
    public static void insertSort(int[] arr) {
        int i, j;   // Loop index variables, declared here for speed
        int temp;   // Temporarily holds swap data
        int n = arr.length;

        // Iterate over array
        // Starts at data[1] to compare with data[0]
        for (i = 1; i < n; i++) {
            j = i;
            // Insert data into sorted part
            // Stopping once data[i] is in correct position
            while (j > 0 && arr[j] < arr[j - 1]) {
                // Swap the data at position j and j-1
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--;    // Decrement j to continue stepping back into sorted list section
            }
        }
    }

    public static void selectSort(int [] arr) {
        int i, j;   // Index variables; faster declared here
        int n = arr.length; // Holds the length of the array
        int temp;   // Holds a value for swap
        int indexSmallest;  // Holds the index of the smallest element

        // Iterate over arr
        for (i = 0; i < n; i++) {
            // Find index of smallest remaining element
            indexSmallest = i;

            for (j = i + 1; j < n; j++) {
                // If arr[j] < arr[indexSmallest], set as indexSmallest
                if (arr[j] < arr[indexSmallest]) {
                    indexSmallest = j;
                }
            }

            // Swap arr[i] and arr[indexSmallest]
            temp = arr[i];
            arr[i] = arr[indexSmallest];
            arr[indexSmallest] = temp;
        }
    }

    public static void quickSort(int [] arr) {
        System.out.println("You've reached quickSort!");
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int [] arr) {
        System.out.println("You've reached mergeSort!");
        mergeSortRecursive(arr, 0, arr.length - 1);
    }

    /** private methods */

    private static void merge(int [] arr, int start, int middle, int end) {
        int mergedSize = end - start + 1;           // Size of merged partition
        int mergePos = 0;                           // Position to insert merged number
        int leftPos = start;                        // Position of elements in left partition
        int rightPos = middle + 1;                  // Position of elements in right partition
        int [] mergedNumbers = new int[mergedSize]; // Dynamically allocates temporary array for merged numbers

        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= middle && rightPos <= end) {
            if (arr[leftPos] <= arr[rightPos]) {
                mergedNumbers[mergePos] = arr[leftPos];     // Add the left value to the mergedNumbers array
                leftPos++;  // Move to the next unmerged value in the left half
            }
            else {
                mergedNumbers[mergePos] = arr[rightPos];    // Add the right value to the mergedNumbers array
                rightPos++; // Move to the next unmerged value in the right half
            }
            mergePos++; // Move to next index in mergedNumbers array
        }

        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= middle) {
            mergedNumbers[mergePos] = arr[leftPos];
            leftPos++;
            mergePos++;
        }

        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= end) {
            mergedNumbers[mergePos] = arr[rightPos];
            rightPos++;
            mergePos++;
        }

        // Copy merge back to numbers
        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            arr[start + mergePos] = mergedNumbers[mergePos];
        }
    }

    private static void mergeSortRecursive(int [] arr, int begin, int end) {
        int mid;    // Stores the midpoint of the array

        // Once begin is greater than end, the base case is reached
        if (begin < end) {
            mid = (begin + end) / 2;  // Find the midpoint of the partition

            // Recursively sort left and right partitions
            mergeSortRecursive(arr, begin, mid);
            mergeSortRecursive(arr, mid + 1, end);

            // Merge left and right partition in sorted order
            merge(arr, begin, mid, end);
        }
    }

    // Returnslocation of last element in low partition
    private static int pivot(int [] arr, int begin, int end) {
        int temp = 0; // Swap temp storage
        boolean done = false;  // Tracks whether function has finished partitioning the data

        // Pick middle element as pivot
        int midpoint = (begin + (end - 1)) /2;
        int pivot = arr[midpoint];

        // Low and high index trackers
        int l = begin;
        int h = end;

        while (!done) {
            // Increment l while arr[l] < pivot
            while (arr[l] < pivot) {
                l++;
            }

            // Decrement h while pivot < arr[h]
            while (pivot < arr[h]) {
                h--;
            }

            // If there are zero or one elements remaining,
            // all numbers are partitioned. Return h
            if (l >= h) {
                done = true;
            }
            else {
                // Swap arr[l] and arr[h],
                // update l and h
                temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;

                l++;
                h--;
            }
        }
        // Return the index of the last element in low partition
        return h;
    }

    private static void quickSortRecursive(int [] arr, int begin, int end) {
        // Base Case:  If there are 1 or zero elements to sort,
        //              partition is already sorted
        if (begin >= end) {
            return;
        }

        // Partition the data within the array.  Value j returned from pivot
        //      is location of last element in low partition
        int j = pivot(arr, begin, end);

        // Recursively sort low partition (begin to j) and high partition (j+1 to k)
        quickSortRecursive(arr, begin, j);
        quickSortRecursive(arr, j + 1, end);
    }
}
