package algo.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] result = sort(new int[]{90, 89, 78, 5, 6, 1, 2, 1, 65, 9});
        for (int node : result) {
            System.out.println(" : " + node + " : ");
        }
    }

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minimumIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minimumIndex] > array[j]) {
                    minimumIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minimumIndex];
            array[minimumIndex] = temp;
        }
        return array;
    }
}
