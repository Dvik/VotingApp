package easyvote.com.model;

/**
 * Created by Divya on 4/17/2016.
 */
public class User {

    public String id;
    public String name;
    public String email;
    public String phone;
    public String password;
    public String manifesto;
    public String qualifications;
    public String experience;

    public User(String id, String name, String email,String phone,String password,String manifesto,String qualifications,
                String experience)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.password=password;
        this.manifesto=manifesto;
        this.qualifications=qualifications;
        this.experience=experience;
    }
}
