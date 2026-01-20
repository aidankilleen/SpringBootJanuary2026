package ie.rc;

import ie.rc.daos.InMemoryUserDao;
import ie.rc.daos.UserDao;
import ie.rc.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryUserDaoTest {

    UserDao dao = new InMemoryUserDao();
    @Test
    public void getAllTest() {


        var users = dao.getAll();
        assertEquals( users.size(), 5);
    }

    @Test
    public void getByIdTest() {


        var user = dao.getById(103);
        assertEquals(user.name(), "Wendy");
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

    @Test
    public void addUserTest() {

        var userToAdd = new User(-1, "Wendy", "wendy@gmail.com", true);
        var addedUser = dao.add(userToAdd);
        assertNotNull(addedUser.id());
    }
}
