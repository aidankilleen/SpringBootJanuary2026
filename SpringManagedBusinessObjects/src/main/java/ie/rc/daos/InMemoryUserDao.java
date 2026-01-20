package ie.rc.daos;

import ie.rc.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class InMemoryUserDao implements UserDao {

    private List<User> users = new ArrayList<>();

    public InMemoryUserDao() {
        users.add(new User(100, "Zoe", "zoe@gmail.com", true));
        users.add(new User(101, "Yvonne", "yvonne@gmail.com", false));
        users.add(new User(102, "Xavier", "xavier@gmail.com", true));
        users.add(new User(103, "Wendy", "wendy@gmail.com", false));
        users.add(new User(104, "Victoria", "vikki@gmail.com", true));
        users.add(new User(105, "Ursula", "urs@gmail.com", true));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User add(User userToAdd) {

        // find the max id
        int maxId=0;
        for (var user:users) {
            if (user.id() > maxId) {
                maxId = user.id();
            }
        }

        User newUser = new User(maxId+1,
                                userToAdd.name(),
                                userToAdd.email(),
                                userToAdd.active());

        users.add(newUser);
        return newUser;
    }

    @Override
    public int delete(int id) {
        int index = findIndex(id);
        users.remove(index);
        return 1;
    }

    @Override
    public User getById(int id) {
        int index = findIndex(id);
        return users.get(index);
    }

    @Override
    public User update(User userToUpdate) {
        int index = findIndex(userToUpdate.id());
        users.set(index, userToUpdate);
        return userToUpdate;
    }

    private int findIndex(int id) {
        for (int i=0; i<users.size(); i++) {
            if (users.get(i).id() == id) {
                return i;
            }
        }
        throw new NoSuchElementException("id not found" + id);
    }
}
