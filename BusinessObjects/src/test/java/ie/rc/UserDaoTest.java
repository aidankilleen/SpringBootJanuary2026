package ie.rc;

import ie.rc.daos.UserDao;
import ie.rc.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDaoTest {

    String url = "jdbc:sqlite:C:\\work\\training\\java\\users.db";

    private Connection conn;
    private UserDao dao;

    @BeforeEach
    public void initialise() throws SQLException {
        System.out.println("initialise() called");
        conn = DriverManager.getConnection(url);
        dao = new UserDao(conn);
    }
    @AfterEach
    public void tidyup() throws SQLException {
        System.out.println("tidyup() called");
        conn.close();
    }
    @Test
    public void verifyInitialisation() throws SQLException {

        assertNotNull(conn);
        assertNotNull(dao);
        conn.close();
    }

    @Test
    public void createUser() throws SQLException {
        var userToAdd = new User(-1, "Wendy", "wendy@gmail.com", true);
        var addedUser = dao.add(userToAdd);
        assertNotNull(addedUser.id());
        conn.close();
    }

}
