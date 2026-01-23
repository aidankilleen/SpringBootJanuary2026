package ie.rc;

import ie.rc.daos.InMemoryUserDao;
import ie.rc.daos.SqlUserDao;
import ie.rc.daos.UserDao;
import ie.rc.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        User u = new User(1, "Alice", "alice@gmail.com", true);

        System.out.println(u);

        UserDao dao = new InMemoryUserDao();

        for (User user: dao.getAll()) {
            System.out.println(user);
        }

        System.out.println("================================");
        String url = "jdbc:sqlite:C:\\work\\training\\java\\production_users.db";
        Connection conn = DriverManager.getConnection(url);
        dao = new SqlUserDao(conn);

        for (User user: dao.getAll()) {
            System.out.println(user);
        }
    }
}