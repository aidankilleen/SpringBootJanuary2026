package ie.rc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqliteHelloWorld {

    public static void main(String[] args) throws SQLException {
        System.out.println("Sqlite Hello World");

        String url = "jdbc:sqlite:C:\\work\\training\\java\\users.db";
        Connection conn = DriverManager.getConnection(url);

        String sql = "SELECT * FROM users";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);
        List<User> users = new ArrayList<>();
        while (rs.next()) {
           int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            boolean active = rs.getBoolean("active");

            User u = new User(id, name, email, active);

            users.add(u);
        }
        rs.close();
        stmt.close();
        conn.close();

        for (var user : users) {
            System.out.println(user);
        }
    }
}
