package algo.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] result = new int[]{4, 1, 2, 1, 5, 7, 3, 9};
        /*sort(result);
        for (int i : result) {
            System.out.println(": " + i + " :");
        }*/
        sortAssignment(result);
        for (int i : result) {
            System.out.println(": " + i + " :");
        }
    }

    public static void sort(int[] array) {
        split(array, 0, array.length - 1);
    }

    public static void split(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            split(array, start, mid);
            split(array, mid + 1, end);
            mergeVariation(array, start, mid, end);
        }
    }

    /*public static void merge(int[] array, int start, int mid, int end) {
        int leftLength = mid - start + 1;
        int rightLength = end - mid;
        int[] left = new int[leftLength + 1];
        int[] right = new int[rightLength + 1];
        for (int i = 0; i < leftLength; i++) {
            left[i] = array[start + i];
        }
        left[left.length-1] = 99999;
        for (int j = 0; j < rightLength; j++) {
            right[j] = array[mid + 1+j];
        }
        right[right.length-1] = 99999;
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
        }
    }*/

    public static void mergeVariation(int[] array, int start, int mid, int end) {
        int[] temporaryArray = new int[end - start + 1];
        int leftIndex = start;
        int rightIndex = mid + 1;
        int k = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (array[leftIndex] < array[rightIndex]) {
                temporaryArray[k] = array[leftIndex];
                leftIndex++;
            } else {
                temporaryArray[k] = array[rightIndex];
                rightIndex++;
            }
            k++;
        }
        if (leftIndex <= mid) {
            while (leftIndex <= mid) {
                temporaryArray[k] = array[leftIndex];
                leftIndex++;
                k++;
            }
        } else if (rightIndex <= end) {
            while (rightIndex <= end) {
                temporaryArray[k] = array[rightIndex];
                rightIndex++;
                k++;
            }
        }
        for (int i = 0; i < temporaryArray.length; i++) {
            array[start + i] = temporaryArray[i];
        }
    }

    // **************************************************************************

    // ---------BELOW IS AN OPTIONAL ASSIGNMENT WITH A REWARD FOR YOU------------

    // **************************************************************************
    /**
     * Hopefully you were able to complete the above merge() method
     * Below is a more challenging implementation.
     * It's called an in-place merge.
     * This is usually pretty difficult for even average programmers to
     * wrap their head around. If you put in the effort to try and understand
     * the below code, you will certainly get it.
     * Here is an incentive for you to put in the time:
     * If you can email me a detailed easy to read explanation
     * in your own words about how the below code works, I'll
     * provide you a 75% discount for all my current and future courses
     * on my online school! my email address is imtiaz@eliminatecodefear.com
     *
     * <br>
     * <b> GOOD LUCK!<b>
     *
     * @param inputArray
     * @param start
     * @param mid
     * @param end
     */
    private static int tempArray[]; // an array used for merging
    // To use the mergeInPlace() method, you'll need to initialize tempArray as
    // shown on the next line inside of the wrapper sort() method.


    public static void sortAssignment(int[] array) {
        tempArray = new int[array.length];
        split(array, 0, array.length - 1);
    }

    public static void mergeInPlace(int inputArray[], int start, int mid, int end) {
        int i = start; // save starting index into temporary variable
        int j = mid + 1;

        for (int k = 0; k <= end; k++) { // Here we are copying the initial array to the temporary array (Unsorted)
            tempArray[k] = inputArray[k];
        }

        for (int k = start; k <= end; k++) {
            if (i > mid) { // If the left side has been completed checking it means the right side is sorted already properly
                inputArray[k] = tempArray[j];
                j = j + 1;
            } else if (j > end) { // If the right side has been completed checking ...
                inputArray[k] = tempArray[i];
                i = i + 1;
            } else if (tempArray[j] < tempArray[i]) { // If both the above If condition fails, then sorting is not yet complete. So we are going to check in here if the left is lesser. then replace it and increment the index
                inputArray[k] = tempArray[j];
                j = j + 1;
            } else {
                inputArray[k] = tempArray[i];
                i = i + 1;
            }
        }
    }

}
