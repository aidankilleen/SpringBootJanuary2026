package ie.rc.SpringBootHelloWorld;

import ie.rc.SpringBootHelloWorld.daos.UserDao;
import ie.rc.SpringBootHelloWorld.models.User;
import ie.rc.SpringBootHelloWorld.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;

@SpringBootApplication
public class SpringBootHelloWorldApplication implements CommandLineRunner {

	@Autowired
	String message;

	@Autowired
	UserManagerService userService;

	ApplicationContext ctx;

	public SpringBootHelloWorldApplication(ApplicationContext ctx) {

		this.ctx = ctx;

		//var msg = ctx.getBean(String.class);

		//System.out.println(msg);

	}



	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Is this working?");
		System.out.println(message);

		var env = ctx.getEnvironment();

		String title = env.getProperty(
				"spring.application.name",
				"DEFAULT TITLE");

		System.out.println(title);

		// User user = ctx.getBean(User.class);
		// System.out.println(user);

		System.out.println("==========================");

		var users = userService.getActiveUsers();

		for (User u: users) {
			System.out.println(u);
		}
	}
}
