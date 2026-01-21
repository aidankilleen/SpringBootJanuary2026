package ie.rc.SpringBootJdbc;

import ie.rc.SpringBootJdbc.daos.UserDao;
import ie.rc.SpringBootJdbc.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringBootJdbcApplicationTests {

	@Autowired
	UserDao dao;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetAll() {

		var users = dao.getAll();
		assertNotNull(users);
		assertNotEquals(users.size(), 0);
	}

	@Test
	void testGetUser3() {

		var user = dao.getById(3);
		assertEquals(user.name(), "Carol");
	}

	@Test
	void testUserNotFound() {
		//verify that getById throws an exception
		// if the user isn't found
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
			var user = dao.getById(99999);
		});
	}

	@Test
	void testDeleteExistingUser() {

		var userToAdd = new User(-1, "XXX", "xxx", false);
		var userToDelete = dao.add(userToAdd);
		int n = dao.delete(userToDelete.id());
		assertEquals(n, 1);
	}

	@Test
	void testDeleteNonExistentUser() {
		int n = dao.delete(99999);
		assertEquals(n, 0);
	}

	@Test
	void testUpdateUser() {
		var users = dao.getAll();
		var lastUser = users.get(users.size() - 1);

		User userToUpdate = new User(lastUser.id(),
									lastUser.name(),
									lastUser.email(),
									!lastUser.active());

		dao.update(userToUpdate);
		User updatedUser = dao.getById(userToUpdate.id());
		assertNotEquals(lastUser.active(), updatedUser.active());
	}

	@Test
	void testAddUser() {

		User userToAdd = new User(-1,
				"NEW USER",
				"new.user@gmail.com",
				true);

		var addedUser = dao.add(userToAdd);

		assertNotEquals(userToAdd.id(), addedUser.id());

		// tidy up after the test
		dao.delete(addedUser.id());
	}






}
