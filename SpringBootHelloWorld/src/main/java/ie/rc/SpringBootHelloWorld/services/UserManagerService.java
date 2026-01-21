package ie.rc.SpringBootHelloWorld.services;


import ie.rc.SpringBootHelloWorld.daos.UserDao;
import ie.rc.SpringBootHelloWorld.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagerService {

    @Autowired
    UserDao dao;

    public List<User> getActiveUsers() {

        var activeUsers = new ArrayList<User>();
        var users = dao.getAll();

        for (User user: users) {

            if (user.active()) {
                activeUsers.add(user);
            }
        }
        return activeUsers;
    }
}
