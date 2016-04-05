import org.h2.*;

import static main.methodOfSort.*;


/**
 * Created by vick on 17.03.16.
 */

public class main {
    //

    public static void main(String[] args) {

        System.out.println("Hello world!!!");

        Test1 test1 = new Test1();


        int[] test = new int[]{10, 24, 30, 45, 1, 0, 44};

        printArray(test);

        sortArray(test, toLower);
        printArray(test);

        sortArray(test, toUpper);
        printArray(test);


        String[] stringFirst = {"Java!"};
        String[] stringSecond = {"Welcome to"};

        System.out.println(stringFirst.toString() + " " + stringSecond);

        swapString(stringFirst, stringSecond);

        System.out.println(stringFirst + " " + stringSecond);


        // return 0;
    }

    /**
     * This function outputs an array on the screen
     * <p/>
     * Эта функция выводит массив на экран
     *
     * @param ar source array (исходный массив)
     */
    public static void printArray(int[] ar) {
        System.out.println("Our array is:");
        for (int i = 0; i < ar.length; i++) {
            try {
                System.out.printf("%d,", ar[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    /**
     * This public function arranges the array on the method of sort
     * @param ar an array
     * @param type type of sorts {@link main.methodOfSort}
     */
    public static void sortArray(int[] ar, methodOfSort type) {
        for (int i = 0; i < ar.length; i++) {
            for (int y = i; y < ar.length; y++) {
                if (((type == methodOfSort.toLower) & (ar[i] < ar[y]))
                        || ((type == toUpper) & (ar[i] > ar[y]))) {
                    swap(ar, i, y);
                }
            }
        }
    }

    /**
     * This function changes two elements of array
     * @param ar an array
     * @param i the first element of the array
     * @param y the second element of the array
     */
    private static void swap(int[] ar, int i, int y) {
        int tmp = ar[i];
        ar[i] = ar[y];
        ar[y] = tmp;

    }

    /**
     * @param str1
     * @param str2
     */
    private static void swapString(String[] str1, String[] str2) {
        String[] _temporaryString = str1;
        str1 = str2;
        str2 = _temporaryString;
    }

    /**
     * The method of sorting
     */
    public enum methodOfSort {
        toLower,
        toUpper
    }

}