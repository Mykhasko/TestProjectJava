import org.h2.*;

import java.sql.*;



/**
 * Created by vick on 17.03.16.
 */

public class main {
    //
    static java.sql.Connection conn;
    static String baseStringPath = "jdbc:h2:~/test";
    static String baseLogin = "sa";
    static String basePassword = "";

    public static void main(String[] args) {

        System.out.println("Hello world!!!");

        Test1 test1 = new Test1();


        int[] test = new int[]{10, 24, 30, 45, 1, 0, 44};

        printArray(test);

        sortArray(test, methodOfSort.toLower);
        printArray(test);

        sortArray(test, methodOfSort.toUpper);
        printArray(test);


        String[] stringFirst = {"Java!"};
        String[] stringSecond = {"Welcome to"};

        System.out.println(stringFirst.toString() + " " + stringSecond);

        swapString(stringFirst, stringSecond);

        System.out.println(stringFirst + " " + stringSecond);

        try {
            testConnectionH2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Next itteration!::");

        try {
            testConnectionH2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int y;
        int x = 2;
        if (x < 0) {
            y = 1;
        } else {
            y = 2;
        }

        System.out.printf("Value y = %d \n", y);

        // testing prime numbers
        java.util.ArrayList<Integer> arL = findPrimeNumbers(1000);

        for (int i = 0; i < arL.size(); i++) {
            System.out.printf((((i + 1) % 10 == 0) ? "%5d\n" : "%5d,"), arL.get(i));
        }


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
                        || ((type == methodOfSort.toUpper) & (ar[i] > ar[y]))) {
                    swap(ar, i, y);
                }
            }
        }
    }

    /**
     * @throws Exception
     */
    private static void testConnectionH2() throws Exception {

        Class.forName("org.h2.Driver");
        if (conn == null || conn.isClosed())
            conn = DriverManager.getConnection(baseStringPath, baseLogin, basePassword);

        String sqlStatment = "select * from TEST";

        ResultSet rs = conn.createStatement().executeQuery(sqlStatment);

        while (rs.next()) {
            System.out.println("ID: \t" + rs.getString("ID") + "\t NAME: \t" + rs.getString("NAME"));
        }

        conn.close();
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
     * This is function for searching prime numbers
     * @param maxFigure range from 1 to max value in where we should find prime numbers
     * @return array of list type Integer
     */
    public static java.util.ArrayList<Integer> findPrimeNumbers(int maxFigure) {
        java.util.ArrayList<Integer> listOfPrimes = new java.util.ArrayList<Integer>();
        for (int i = 1; i < maxFigure; i++) {
            boolean isPrimeNumber = true;
            for (int _index = 0; _index < listOfPrimes.size(); _index++) {
                int divide = listOfPrimes.get(_index);
                if (i % divide == 0 && divide != 1) {
                    isPrimeNumber = false;
                    break;
                }

            }
            // if a number is prime we will add in array list
            if (isPrimeNumber) {
                listOfPrimes.add(i);
            }
        }

        return listOfPrimes;
    }

    /**
     * The method of sorting
     */
    public enum methodOfSort {
        toLower,
        toUpper
    }
}