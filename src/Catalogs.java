import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vick on 25.05.16.
 */
public class Catalogs {

    public static class Currencies{

        /**
         *
         * @param idCurrency
         * @return
         */
        public Currency getCurrenciesByID(int idCurrency){
            Currency gettingInstanceCurrency =  new Currency();

            return gettingInstanceCurrency;
        }

        /**
         *
         * @return
         */
        public java.util.ArrayList<Currency> getCurenciesList() {
            java.util.ArrayList<Currency> currencyArrayList = new java.util.ArrayList<Currency>();

            String sqlQuery = "SELECT t.IDCURRENCY, t.NAME, t.INTERNATIONALCODE, t.INTERNATIONALSYMBOL, t.DESCRIPTION FROM CURRENCIES AS t";
            try {
                ResultSet rs = database.executeQuery(sqlQuery);
                while (rs.next()) {
                    currencyArrayList.add(this.extractFromResultSet(rs));
                }
            } catch (Exception ex) {

            }

            return currencyArrayList;
        }


        /**
         *
         * @param newCurrency
         * @return
         */
        public boolean addCurrency(Currency newCurrency){

            boolean result = false;
            String queryText = "";

            try {

                result = database.execute(queryText);
            } catch (Exception ex)
            {

            }
            return result;

        }

        /**
         *
         * @param rs текущая запись ResultSet
         * @return Currency экземпляр класса основанный на записи SQL
         */
        private Currency extractFromResultSet(ResultSet rs){
            Currency gettingInstanceCurrency =  new Currency();
            try {
                 gettingInstanceCurrency =  new Currency(
                         rs.getInt("IDCURRENCY"),
                         rs.getString("NAME"),
                         rs.getString("INTERNATIONALCODE"),
                         rs.getString("INTERNATIONALSYMBOL"),
                         rs.getString("DESCRIPTION")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return gettingInstanceCurrency;
        }
    }


}
