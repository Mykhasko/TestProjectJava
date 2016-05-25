/**
 * Created by vick on 31.03.16.
 */
public class Security implements ISecurity {

    private int id;


    private String Name;

    /**
     *
     */
    public void PrintOut(){
        System.out.println("Security class");
    }


    @Override
    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public String getName() {
        return this.Name;
    }
}
