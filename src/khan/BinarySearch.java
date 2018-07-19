package khan;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 4, 5, 8, 11, 18, 21, 27, 40, 66}, 180));
    }

    public static int search(int[] array, int target) {
        int start = 0;
        int end = array.length-1;
        int count = 0;
        while (start <= end) {
            int mid = (start + end)/2;
            if (array[ mid ] == target) {
                System.out.println("count: "+count);
                return mid;
            } else if (array[ mid ] < target) {
                start = mid +1;
            } else {
                end = mid-1;
            }
            count++;
        }
        return -1;
    }
}