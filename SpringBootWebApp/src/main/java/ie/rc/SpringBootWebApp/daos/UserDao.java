package ie.rc.SpringBootWebApp.daos;



import ie.rc.SpringBootWebApp.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User add(User userToAdd);

    int delete(int id);

    User getById(int id);

    User update(User userToUpdate);
}
