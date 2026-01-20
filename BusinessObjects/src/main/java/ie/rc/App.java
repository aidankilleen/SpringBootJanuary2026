package ie.rc;

import ie.rc.daos.InMemoryUserDao;
import ie.rc.daos.SqlUserDao;
import ie.rc.daos.UserDao;
import ie.rc.models.User;

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

        System.out.println( "Business Objects" );

        //String url = "jdbc:sqlite:C:\\work\\training\\java\\users.db";
        //Connection conn = DriverManager.getConnection(url);
        UserDao dao = new InMemoryUserDao();

        var users = dao.getAll();

        for (User user: users) {
            System.out.println(user);
        }

        User u = dao.getById(102);

        System.out.println(u);
/*
        User userToAdd = new User(-1,
                            "Xavier",
                            "xavier@gmail.com",
                            false);

        User addedUser = dao.add(userToAdd);

        System.out.println(addedUser);
*/

        //conn.close();

    }
}
