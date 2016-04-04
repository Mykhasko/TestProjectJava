/**
 * Created by vick on 17.03.16.
 */

public class main {
    //
    public static void main(String[] args) {

        System.out.println("Hello world!!!");


        int[] test = new int[]{10, 24, 30, 45, 1, 0, 44};

        printArray(test);

        sortArray(test, methodOfSort.toLower);
        printArray(test);

        sortArray(test, methodOfSort.toUpper);
        printArray(test);


        // return 0;
    }

    public static void printArray(int[] ar) {
        System.out.println("Our array is:");
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%d,", ar[i]);
        }
        System.out.println();
    }


    public static void sortArray(int[] ar, methodOfSort type) {
        for (int i = 0; i < ar.length; i++) {
            for (int y = i; y < ar.length; y++) {
                if (((type == methodOfSort.toLower) & (ar[i] < ar[y]))
                        || ((type == methodOfSort.toUpper) & (ar[i] > ar[y]))) {
                    swap(ar, i, y);
                }
            }
        }
    }


    private static void swap(int[] ar, int i, int y) {
        int tmp = ar[i];
        ar[i] = ar[y];
        ar[y] = tmp;

    }

    public enum methodOfSort {toLower, toUpper}

}