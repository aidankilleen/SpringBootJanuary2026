package ie.rc.prepsharedlibrary.daos;



import ie.rc.prepsharedlibrary.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User add(User userToAdd);

    int delete(int id);

    User getById(int id);

    User update(User userToUpdate);
}
