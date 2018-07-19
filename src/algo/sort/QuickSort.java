package algo.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] result = new int[]{4, 1, 2, 1, 5, 7, 3, 9, 7, 8, 4, 99, 6};
        sort(result);
        for (int i : result) {
            System.out.println(": " + i + " :");
        }
    }

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int q = partition(array, start, end);
            quickSort(array, start, q - 1);
            quickSort(array, q + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
        int i = start - 1;
        int j = start;
        while (j < end) {
            if (array[j] < array[end]) {
                i++;
                int temporary = array[i];
                array[i] = array[j];
                array[j] = temporary;
            }
            j++;
        }
        int pivotSwapper = array[i + 1];
        array[i + 1] = array[end];
        array[end] = pivotSwapper;
        return i + 1;
    }
}
