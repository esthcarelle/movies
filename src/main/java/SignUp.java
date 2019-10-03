import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class SignUp {
    private String name;
    private String email;
    private String password;
    private int id;

    public SignUp(String name,String email,String password) {
        this.name=name;
        this.email=email;
        this.password=password;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void save(SignUp signUp) {
        String sql = "INSERT INTO users (name,email,password) VALUES (:name,:email,:password);";
        try(Connection con = DB.sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(signUp)
                    .executeUpdate()
                    .getKey();
            signUp.setId(id);
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }
    public void saveAdmin(SignUp signUp) {
        String sql = "INSERT INTO admins (name,email,password) VALUES (:name,:email,:password);";
        try(Connection con = DB.sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(signUp)
                    .executeUpdate()
                    .getKey();
            signUp.setId(id);
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }
}
