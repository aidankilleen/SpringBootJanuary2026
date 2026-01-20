package ie.rc;

import ie.rc.daos.SqlUserDao;
import ie.rc.daos.UserDao;
import ie.rc.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class SqlUserDaoTest {

    String url = "jdbc:sqlite:C:\\work\\training\\java\\users.db";

    private Connection conn;
    private UserDao dao;

    @BeforeEach
    public void initialise() throws SQLException {
        conn = DriverManager.getConnection(url);
        dao = new SqlUserDao(conn);
    }
    @AfterEach
    public void tidyup() throws SQLException {
        conn.close();
    }
    @Test
    public void verifyInitialisation() throws SQLException {

        assertNotNull(conn);
        assertNotNull(dao);
    }

    @Test
    public void createUser() throws SQLException {
        var userToAdd = new User(-1, "Wendy", "wendy@gmail.com", true);
        var addedUser = dao.add(userToAdd);
        assertNotNull(addedUser.id());

        // tidy up the database
        dao.delete(addedUser.id());
    }

    @Test
    public void deleteUser() {

        var userToAdd = new User(-1, "DELETE ME", "delete.me@gmail.com", true);
        var addedUser = dao.add(userToAdd);

        int n = dao.delete(addedUser.id());
        assertNotEquals(n, 0);
    }

    @Test
    public void getByIdTest() {

        var users = dao.getAll();
        var userToFind = users.get(0);
        var foundUser = dao.getById(userToFind.id());

        assertEquals(userToFind, foundUser);
    }

    @Test
    public void updateUserTest() {
        // get the first user
        var firstUser = dao.getAll().get(0);

        var userToUpdate = new User(firstUser.id(),
                                    firstUser.name(),
                                    firstUser.email(),
                                    !firstUser.active());
        dao.update(userToUpdate);
        var foundUser = dao.getById(firstUser.id());
        assertNotEquals(firstUser.active(), foundUser.active());
    }
}

