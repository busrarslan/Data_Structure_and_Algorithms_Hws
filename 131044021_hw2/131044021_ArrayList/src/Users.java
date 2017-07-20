import java.util.ArrayList;
import java.util.List;


public abstract class Users implements Person {
    private String password;
    private String username;

    /**
     *
     */
    public Users(){}

    /**
     *
     * @param name
     * @param passW
     */
    public Users(String name, String passW){
        setPassword(passW);
        setUsername(name);
    }


    /**
     *
     * @return
     */
    @Override
    public String getPassword(){
        return password;
    }

    /**
     *
     * @return
     */
    @Override
    public String getUsername(){
        return username;
    }

    /**
     *
     * @param passW
     */
    @Override
    public void setPassword(String passW){
        password=passW;
    }

    /**
     *
     * @param name
     */
    @Override
    public void setUsername(String name){
        username=name;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Users{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}