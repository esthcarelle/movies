import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class App {
    public static void main(String[] args) {


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "signup.hbs");
        },new HandlebarsTemplateEngine());
        get("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "success.hbs");
        },new HandlebarsTemplateEngine());

        get("/successAdmin", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "successAdmin.hbs");
        },new HandlebarsTemplateEngine());
        get("/userPage", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("uploads",Upload.getAll());
            return new ModelAndView(model, "userPage.hbs");
        },new HandlebarsTemplateEngine());

        get("/login", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "login.hbs");
        },new HandlebarsTemplateEngine());

        get("/loginAdmin", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "loginAdmin.hbs");
        },new HandlebarsTemplateEngine());

        get("/newAdmin", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "adminSignUp.hbs");
        },new HandlebarsTemplateEngine());




        post("/newUser", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String email= request.queryParams("email");
            String password=request.queryParams("password");
            SignUp newUser= new SignUp(name, email, password);
            newUser.save(newUser);
            model.put("users",newUser);
            response.redirect("/success");

            return new ModelAndView(model, "signup.hbs");
        }, new HandlebarsTemplateEngine());

        post("/newAdmin", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String email= request.queryParams("email");
            String password=request.queryParams("password");
            SignUp newUser= new SignUp(name, email, password);
            newUser.saveAdmin(newUser);
            model.put("users",newUser);
            response.redirect("/success");

            return new ModelAndView(model, "adminSignUp.hbs");
        }, new HandlebarsTemplateEngine());


        post("/login", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String password=request.queryParams("password");
            List<SignUp> user=Login.getUser(name,password);
            System.out.println(user);
            if(user.isEmpty()){
                response.redirect("/");
            }
            else{
                response.redirect("/successAdmin");
            }
            return new ModelAndView(model, "signup.hbs");
        }, new HandlebarsTemplateEngine());

        post("/loginAdmin", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String password=request.queryParams("password");
            List<SignUp> admin=Login.getAdmins(name,password);
            System.out.println(admin);
            if(admin.isEmpty()){
                response.redirect("/");
            }
            else{
                response.redirect("/success");
            }
            return new ModelAndView(model, "adminSignUp.hbs");
        }, new HandlebarsTemplateEngine());

        get("/upload", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "upload.hbs");
        },new HandlebarsTemplateEngine());


        post("/upload", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String picture = request.queryParams("picture");
            String caption = request.queryParams("caption");
            String video = request.queryParams("video");
            Upload newUpload = new Upload(picture, caption, video);
            newUpload.save(newUpload);
            model.put("uploads", Upload.getAll());
            response.redirect("/stream");
            return new ModelAndView(model, "stream.hbs");
        }, new HandlebarsTemplateEngine());

        get("/stream", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            System.out.println(Upload.getAll());
            model.put("uploads",Upload.getAll());
            return new ModelAndView(model, "stream.hbs");
        },new HandlebarsTemplateEngine());


        post("/search", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String caption= request.queryParams("caption");
            System.out.println(Upload.getAllSearched(caption));
            model.put("stream",Upload.getAllSearched(caption));
//            response.redirect("/search");
            return new ModelAndView(model, "search-details.hbs");

        }, new HandlebarsTemplateEngine());
//
//        String link="https://btsmediablog.files.wordpress.com/2016/12/rick-warren-the-purpose-driven-life-what-on-earth-am-i-here-for.pdf";
//        File out =new File("/home/esther/Downloads");
//        new Thread(new Download(link,out)).start();

        get("/search", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "search-details.hbs");
        },new HandlebarsTemplateEngine());

        get("/delete/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfUploadToDelete = Integer.parseInt(req.params("id"));
            Upload.deleteById(idOfUploadToDelete);
            res.redirect("/stream");
            return null;
        }, new HandlebarsTemplateEngine());









    }

}
