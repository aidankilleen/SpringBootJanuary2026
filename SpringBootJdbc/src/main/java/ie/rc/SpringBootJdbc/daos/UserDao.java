package ie.rc.SpringBootJdbc.daos;


import ie.rc.SpringBootJdbc.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User add(User userToAdd);

    int delete(int id);

    User getById(int id);

    User update(User userToUpdate);
}
