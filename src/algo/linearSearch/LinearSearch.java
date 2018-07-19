package algo.linearSearch;

public class LinearSearch {

    public LinearSearch() {

    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 100;
        }
        System.out.println(search(array, 0));
    }

    public static int search(int[] a, int x) {
        int result = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return (result = i);
            }
        }
        return result;
    }
}