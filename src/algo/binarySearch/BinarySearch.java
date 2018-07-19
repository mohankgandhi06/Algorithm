package algo.binarySearch;

public class BinarySearch {

    public static void main(String [] args) {
        int[] a = {2,3,5,6,7,8,9,10,15,20};
        System.out.println(search(a, 100));
    }

    public static int search(int[] a, int x) {
        int firstIndex = 0;
        int lastIndex = a.length - 1;
        while (firstIndex <= lastIndex) {
            int midIndex = Math.floorDiv((firstIndex + lastIndex), 2);
            if (a[midIndex] == x) {
                return midIndex;
            } else if (a[midIndex] > x) {//First Half
                firstIndex = firstIndex;//Not needed actually
                lastIndex = midIndex - 1;
            } else {//Second Half
                firstIndex = midIndex + 1;
                lastIndex = lastIndex;//Not needed actually
            }
        }
        return -1;
    }
}
