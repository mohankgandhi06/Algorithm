package khan;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoiArray {

    private static int noOfRings = 6;
    private static String[] arrayA = new String[ noOfRings ];
    private static String[] arrayB = new String[ noOfRings ];
    private static String[] arrayC = new String[ noOfRings ];
    private static int counter = 0;

    public static void main(String[] args) {
        arrayA[ 0 ] = "A";
        arrayB[ 0 ] = "B";
        arrayC[ 0 ] = "C";
        for (int i = arrayA.length - 1; i > 0; i--) {
            arrayA[ i ] = Integer.toString(arrayA.length - i);
            arrayB[ i ] = Integer.toString(0);
            arrayC[ i ] = Integer.toString(0);
        }
        solveTheHanoi(arrayA, arrayB);
        System.out.println("A Array:");
        for (int k = 0; k < arrayA.length; k++) {
            System.out.println("Position: " + k + " Value: " + arrayA[ k ]);
        }
        System.out.println("B Array:");
        for (int k = 0; k < arrayB.length; k++) {
            System.out.println("Position: " + k + " Value: " + arrayB[ k ]);
        }
        System.out.println("C Array:");
        for (int k = 0; k < arrayC.length; k++) {
            System.out.println("Position: " + k + " Value: " + arrayC[ k ]);
        }
        System.out.println("Arrived at the solution in : " + counter + " turns..... :)");
    }

    public static void solveTheHanoi(String[] currentArray, String[] nextArray) {
        int upperElementIndex = findUpperElement(currentArray);
        int upperElementNextArrayIndex = findUpperElement(nextArray);
        List<String[]> list = new ArrayList<String[]>();
        while (Integer.valueOf(arrayB[ noOfRings - 1 ]) != 1) {
            if (upperElementIndex == -1) {
                // It means the CurrentArray is Empty. So we can move on to the next array
                // Not Inserting
                list = findCurrentAndNextArray(currentArray, nextArray, 1);
            } else if (upperElementNextArrayIndex == -1) {
                // It means the CurrentArray Top element can be inserted here in the NextArray
                // After Inserting
                nextArray[ 1 ] = currentArray[ upperElementIndex ];
                currentArray[ upperElementIndex ] = Integer.toString(0);
                list = findCurrentAndNextArray(currentArray, nextArray, 2);
            } else if (Integer.valueOf(currentArray[ upperElementIndex ]) > Integer.valueOf(nextArray[ upperElementNextArrayIndex ])) {
                // It means we have to move to the next array since we cannot place the weight here in the NextArray
                // Not Inserting
                list = findCurrentAndNextArray(currentArray, nextArray, 3);
            } else {
                // It means that the above all conditions have failed i.e. the value is lower. So we can insert the CurrentArray to NextArray
                // After Inserting
                nextArray[ upperElementNextArrayIndex + 1 ] = currentArray[ upperElementIndex ];
                currentArray[ upperElementIndex ] = Integer.toString(0);
                list = findCurrentAndNextArray(currentArray, nextArray, 4);
            }
            counter++;
            solveTheHanoi(list.get(0), list.get(1));
            break;
        }
    }

    private static int findUpperElement(String[] currentArray) {
        for (int i = currentArray.length - 1; i > 0; i--) {
            if (Integer.valueOf(currentArray[ i ]) != 0) {
                return i;
            }
        }
        return -1;
    }

    private static List<String[]> findCurrentAndNextArray(String[] currentArray, String[] nextArray, int i) {
        List<String[]> list = new ArrayList<String[]>();
        switch (i) {
            case 1:
                currentArray = nextArray;
                nextArray = findNext(currentArray);
                break;
            case 2:
                currentArray = findNext(nextArray);
                nextArray = findNext(currentArray);
                break;
            case 3:
                nextArray = findNext(nextArray);
                if (!nextArray[ 0 ].equalsIgnoreCase(currentArray[ 0 ])) {
                    currentArray = currentArray;
                } else {
                    currentArray = findNext(currentArray);
                    nextArray = findNext(currentArray);
                }
                break;
            case 4:
                currentArray = findNext(nextArray);
                nextArray = findNext(currentArray);
                break;
        }
        list.add(0, currentArray);
        list.add(1, nextArray);
        return list;
    }

    private static String[] findNext(String[] array) {
        if (array[ 0 ].equalsIgnoreCase("A")) {
            return arrayB;
        } else if (array[ 0 ].equalsIgnoreCase("B")) {
            return arrayC;
        } else {
            return arrayA;
        }
    }

}