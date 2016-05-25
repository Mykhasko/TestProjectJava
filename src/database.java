import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by vick on 25.05.16.
 */
public class  database {

    public static String databasePath = "";
    public static String login = "";
    public static String password = "";

    public static String class4Name = "org.h2.Driver";

    static java.sql.Connection connectionDB;


    public database(String databasePath, String login, String password) {
        this.databasePath   = databasePath;
        this.login          = login;
        this.password       = password;
    }


    /**
     * @throws Exception
     */
    protected static ResultSet executeQuery(String textQuery) throws Exception {

        Class.forName(class4Name);
        if (connectionDB == null || connectionDB.isClosed())
            connectionDB = DriverManager.getConnection(databasePath, login, password);

            String sqlStatment = textQuery;

             ResultSet rs = connectionDB.createStatement().executeQuery(sqlStatment);

        //connectionDB.close();

        return  rs;
    }

    /**
     * @throws Exception
     */
    protected static boolean execute(String textQuery) throws Exception {

        Class.forName(class4Name);
        if (connectionDB == null || connectionDB.isClosed())
            connectionDB = DriverManager.getConnection(databasePath, login, password);

        String sqlStatment = textQuery;

       return connectionDB.createStatement().execute(sqlStatment);



    }
}
