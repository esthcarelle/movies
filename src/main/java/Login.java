import org.sql2o.Connection;

import java.util.List;

public class Login {
    private String name;
    private String password;
    public Login(String name,String password) {
        this.name=name;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
//    public static  List<SignUp> getUser() {
//        String sql = "SELECT * FROM users WHERE name="+"'"+this.name+"'" +" AND password="+"'"+this.password+"'";
//        System.out.println(sql);
//        try (Connection con = DB.sql2o.open()) {
//            return con.createQuery(sql)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(SignUp.class);
//        }
//
//    }
    public static List<SignUp> getUser(String name,String password) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE name= :name AND password=:password")
                    .addParameter("name", name)
                    .addParameter("password", password)
                    .executeAndFetch(SignUp.class);
        }
    }
    public static List<SignUp> getAdmins(String name,String password) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM admins WHERE name= :name AND password=:password")
                    .addParameter("name", name)
                    .addParameter("password", password)
                    .executeAndFetch(SignUp.class);
        }
    }
}
