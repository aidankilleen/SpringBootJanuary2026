package ie.rc.SpringBootHelloWorld.daos;



import ie.rc.SpringBootHelloWorld.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User add(User userToAdd);

    int delete(int id);

    User getById(int id);

    User update(User userToUpdate);
}
