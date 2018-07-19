package algo.sort;

public class InsertionSort {
    public static void main(String[] args) {
        //int[] result = sort(new int[]{2, 90, 89, 78, 5, 1, 2, 1, 65, 9});
        int[] result = sort(new int[]{2, 90, 1});
        for (int node : result) {
            System.out.println(" : " + node + " : ");
        }
    }

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
        return array;
    }

    public static int[] sortVariation(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int element = array[i];//Taking the element at the unsorted side
            int j = i - 1;//Taking the index as the last sorted index position
            while (j >= 0 && array[j] > element) {//Swap only till the a[j] is greater than the element which is in the unsorted side
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = element;
        }
        return array;
    }
}
