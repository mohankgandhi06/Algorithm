package algo.recursive;

public class Recursive {
    public static void main(String[] args) {
        reduceByOne(9);
        recursiveLinearSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, 7);
        System.out.println(recursiveBinarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, 8, 6));
        System.out.println((4+19)/2);
    }

    public static void reduceByOne(int a) {
        if (a >= 0) {
            reduceByOne(a - 1);
        }
        System.out.println("Completed Call : " + a);
    }

    public static int recursiveLinearSearch(int[] a, int i, int x) {
        if (i > a.length) {
            return -1;
        } else if (a[i] == x) {
            return i;
        } else {
            return recursiveLinearSearch(a, i + 1, x);
        }
    }

    public static int recursiveBinarySearch(int[] a, int p, int r, int x) {
        if (p > r) {
            return -1;
        } else {
            int midIndex = Math.floorDiv((p + r), 2);
            if (a[midIndex] == x) {
                return midIndex;
            } else if (a[midIndex] > x) {//First Half
                return recursiveBinarySearch(a, p, midIndex - 1, x);
            } else {//Second Half
                return recursiveBinarySearch(a, midIndex + 1, r, x);
            }
        }
    }
}