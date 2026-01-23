package ie.rc;

import ie.rc.prepsharedlibrary.daos.InMemoryUserDao;
import ie.rc.prepsharedlibrary.daos.SqlUserDao;
import ie.rc.prepsharedlibrary.daos.UserDao;
import ie.rc.prepsharedlibrary.models.User;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );

        var url = "jdbc:sqlite:c:\\work\\training\\java\\production_users.db";
        var conn = DriverManager.getConnection(url);
        UserDao dao = new SqlUserDao(conn);

        var users = dao.getAll();

        for (User user:users) {
            System.out.println(user);
        }
    }
}
