package sqlapp.akrimkermi.com.Metier;

/**
 * Created by akrim on 22/05/2015.
 */
public class User {

    private String name;
    private String email;
    private String password;



    public User(){
        super();
    }
    public User(String name, String email, String password){
                this.name = name;
                this.email=email;
                this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}