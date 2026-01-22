package ie.rc.SpringBootTemplatedWebApp.daos;


import ie.rc.SpringBootTemplatedWebApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class JdbcTemplateUserDao implements UserDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        return jdbc.query(sql, new UserRowMapper());
    }

    @Override
    public User add(User userToAdd) {

        String sql = "INSERT INTO users (name, email, active) VALUES(?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, userToAdd.name());
            ps.setString(2, userToAdd.email());
            ps.setBoolean(3, userToAdd.active());

            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();

        if (key == null) {
            throw new IllegalStateException("Insert succeeded but key not generated");
        }
        int newId = key.intValue();

        return new User(newId,
                        userToAdd.name(),
                        userToAdd.email(),
                        userToAdd.active());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbc.update(sql, id);
    }

    @Override
    public User getById(int id) {
        User user = null;
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            user = jdbc.queryForObject(sql, new UserRowMapper(), id);

        } catch(EmptyResultDataAccessException ex) {

            throw new IllegalArgumentException("User not found:" + id);
        }
        return user;
    }

    @Override
    public User update(User userToUpdate) {
        String sql = "UPDATE users SET name=?, email=?, active=? WHERE id=?";

        jdbc.update(sql,
                userToUpdate.name(),
                userToUpdate.email(),
                userToUpdate.active(),
                userToUpdate.id());
        // TODO add some error checking

        return userToUpdate;
    }
}
