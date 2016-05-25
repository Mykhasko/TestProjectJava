/**
 * Created by vick on 25.05.16.
 */
public class Currency {

    /**
     * Private - this is new object, which you can't find in database
     */
    private boolean isNew = false;


    /**
     * id in database if the instance is new , this parameter will be equal 0
     */
    private int idCurrency;

    private String name = " *** Empty name ***";

    private String internationalCode = "000";

    private String internationalSymbol = "***";

    private String description = "";

    public int getIdCurrency() {
        return idCurrency;
    }

    /**
     * Getting name of currency
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setting name of currency
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getInternationalCode() {
        return internationalCode;
    }

    public void setInternationalCode(String intenationalCode) {
        this.internationalCode = ("" + intenationalCode + "000").substring(0,3);
    }

    public String getInternationalSymbol() {
        return internationalSymbol;
    }

    public void setInternationalSymbol(String internationalSymbol) {
        this.internationalSymbol = "   " + internationalSymbol.toUpperCase();
        this.internationalSymbol = this.internationalSymbol.substring(
                        this.internationalSymbol.length()-3,
                        this.internationalSymbol.length());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNew(){
        return this.isNew;
    }

    /**
     * Default constaructor without any parameters
     */
    public Currency(){
        this.isNew                   = true;
        this.idCurrency              = 0;
        this.name                    = " *** Empty name ***";
        this.internationalCode       = "000";
        this.internationalSymbol     = "***";
        this.description             = "";

    }

    /**
     * The constructor with adding parametrs
     * @param name
     * @param internationalCode
     * @param internationalSymbol
     * @param description
     */
    public Currency(String name, String internationalCode, String internationalSymbol, String description){

        this.setName(name);
        this.setInternationalCode(internationalCode);
        this.setInternationalSymbol(internationalSymbol);
        this.setDescription(description);
    }

    /**
     * The constructor with adding parameters
     * @param idCurrency
     * @param name
     * @param internationalCode
     * @param internationalSymbol
     * @param description
     */
    protected Currency(int idCurrency, String name, String internationalCode, String internationalSymbol, String description){
        this.isNew      = false;
        this.idCurrency = idCurrency;
        this.setName(name);
        this.setInternationalCode(internationalCode);
        this.setInternationalSymbol(internationalSymbol);
        this.setDescription(description);
    }




}
