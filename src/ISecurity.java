/**
 * Created by vick on 30.03.16.
 */
public interface ISecurity {

    String Name = "" ;

    int Id = 0;

    EnTypeSecurity Type = EnTypeSecurity.SECURITY;

    public void setName(String name);

    public String getName();

    default String printOut(){
        return Name;
    }

}
