package ie.rc.daos;

// do the CRUD operations on the user database
// Create
// Retrieve
// Update
// Delete

import ie.rc.models.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection conn;

    public UserDao(){}

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    public List<User> getAll() {

        List<User> users = new ArrayList<User>();

        // read these from the database!
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users";

            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                var id = rs.getInt("id");
                var name = rs.getString("name");
                var email = rs.getString("email");
                var active = rs.getBoolean("active");

                users.add(new User(id, name, email, active));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public User add(User userToAdd) {
        try {
            Statement stmt = conn.createStatement();
            String sql = """
                        INSERT INTO users 
                        (name, email, active) 
                        VALUES('%s', '%s', '%d')
                        """.formatted(userToAdd.name(),
                                        userToAdd.email(),
                                        userToAdd.active() ? 1 : 0);
            stmt.executeUpdate(sql);

            var rs = stmt.getGeneratedKeys();
            int newId = rs.getInt(1);
            return new User(newId,
                                    userToAdd.name(),
                                    userToAdd.email(),
                                    userToAdd.active());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id) {
        // delete user with id
        throw new UnsupportedOperationException("TBD");
    }
    public User update(User userToUpdate) {
        throw new UnsupportedOperationException("TBD");
    }
    public User getById(int id) {
        throw new UnsupportedOperationException("TBD");
    }
}
