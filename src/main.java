import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.DriverManager;
import java.sql.ResultSet;



/**
 * Created by vick on 17.03.16.
 */

public class main {
    //
    static java.sql.Connection conn;
    static String baseStringPath = "jdbc:h2:/home/vick/IdeaProjects/TestProject/TestProject"; //jdbc:h2:~/tesH2 - TestProject
    static String baseLogin = "";
    static String basePassword = "";

    public static int $;

    public static void main(String[] args) {

        System.out.print($);

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

        System.out.println("Next iteration!::");

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
        java.util.ArrayList<Integer> arL = new java.util.ArrayList<Integer>();
        try {
            arL = findPrimeNumbers(1000);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        for (int i = 0; i < arL.size(); i++) {
            System.out.printf((((i + 1) % 10 == 0) ? "%5d\n" : "%5d,"), arL.get(i));
        }

        try {
            PrintWriter writer = new PrintWriter("text.txt","UTF-8");

            for (int i = 0; i < arL.size(); i++) {
                writer.printf("%5d;", arL.get(i));
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //////
        System.out.printf("\nTest class:\n");
        Security[] arraySecurity = new Security[]{new Security(), new Future(), new Bond(),new Future(), new Security()};
        for (int i = 0; i < arraySecurity.length; i++){
            arraySecurity[i].PrintOut();
        }

        System.out.printf("\nTest interface:\n");
        ISecurity[] ar = new ISecurity[]{ new Security(), new Future(), new Bond(),new Future(), new Security()};
        ((ISecurity)ar[0]).setName("Sec1");
        ar[1].setName("Fut1");
        ar[2].setName("Bond1");
        ar[3].setName("Fut1");
        ar[4].setName("Sec2");
        for (int i = 0; i < ar.length; i++){
            System.out.println("Name:" + ar[i].getName());
            System.out.println("Name:" + ar[i].printOut() );
        }



        System.out.println("======================================================================================");
        database.databasePath = "jdbc:h2:/home/vick/IdeaProjects/TestProject/TestProject";
        database.login = "";
        database.password = "";

        java.util.ArrayList<Currency> currencyArrayList = new Catalogs.Currencies().getCurenciesList();

        for (int i = 0; i < currencyArrayList.size(); i++){
            Currency _t1 = currencyArrayList.get(i);
            System.out.printf(" ID: %d \t Name: %s \t International code: %s \t International Symbol: %s \n", _t1.getIdCurrency(), _t1.getName(),_t1.getInternationalCode(),_t1.getInternationalSymbol());
        }

        System.out.println("======================================================================================");

       /* //05/05/2016
        (int n) -> { while(n >0){
            System.out.println(n);
            n=n/2;
            }
        }*/

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

        String sqlStatment = "SELECT t.IDCURRENCY,t.INTERNATIONALCODE,t.INTERNATIONALSYMBOL,t.NAME FROM PUBLIC.CURRENCIES AS t";

        ResultSet rs = conn.createStatement().executeQuery(sqlStatment);

        while (rs.next()) {
            System.out.println("ID: \t" + rs.getString("IDCURRENCY") + "\t NAME: \t" + rs.getString("NAME"));
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
     * @Exception numbers less 0
     */
    public static java.util.ArrayList<Integer> findPrimeNumbers(int maxFigure) throws Exception {
        // Checking entire parametr
        if(maxFigure < 0 ) throw  new Exception("Parameter should be more than zero!");

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