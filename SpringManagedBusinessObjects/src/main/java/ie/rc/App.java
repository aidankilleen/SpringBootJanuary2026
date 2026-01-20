package ie.rc;

import ie.rc.daos.SqlUserDao;
import ie.rc.daos.UserDao;
import ie.rc.models.User;
import ie.rc.services.GeneralService;
import ie.rc.services.UserManagerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        var env = ctx.getEnvironment();

        String title = env.getProperty("app.title");
        System.out.println(title);

        String author = env.getProperty("app.author",
                                "Aidan Killeen (default)");
        System.out.println(author);

        String url = env.getProperty("database.url");
        System.out.println(url);

        String message = ctx.getBean(String.class);
        System.out.println(message);


        //User u = ctx.getBean(User.class);
        //System.out.println(u);



        //String url = "jdbc:sqlite:C:\\work\\training\\java\\users.db";
        //Connection conn = DriverManager.getConnection(url);
        //UserDao dao = new SqlUserDao(conn);

        // @Autowiring ONLY works on spring-managed beans
        // REALLY COMMON ERROR
        // UserDao dao = new SqlUserDao();

        // UserDao dao = ctx.getBean(UserDao.class);

        UserManagerService ums = ctx.getBean(UserManagerService.class);

        var users = ums.getActiveUsers();

        for (User user:users) {
            System.out.println(user);
        }


        GeneralService gs = ctx.getBean(GeneralService.class);
        gs.displayMessage();

    }
}
