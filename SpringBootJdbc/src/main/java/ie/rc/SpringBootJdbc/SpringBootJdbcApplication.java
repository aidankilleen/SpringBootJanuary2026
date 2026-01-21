package ie.rc.SpringBootJdbc;

import ie.rc.SpringBootJdbc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

	String appName;

	@Autowired
	JdbcTemplate jdbc;

	public SpringBootJdbcApplication(@Value("${spring.application.name}") String appName){
		this.appName = appName;
	}

	private static RowMapper<User> USER_MAPPER = new RowMapper<User>(){
		@Nullable
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getBoolean("active"));
		}
	};

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);

		// there is nothing spring-related you can do in the main() method
		// you can't access the context, you can't access the dependency injected values etc.
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(appName);

		String sql = "SELECT COUNT(*) FROM users";
		int count = jdbc.queryForObject(sql, Integer.class);
		System.out.printf("Record Count=%d\n", count);

		sql = "SELECT * FROM users WHERE id=3";
		var user = jdbc.queryForObject(sql, USER_MAPPER);
		System.out.println(user);

		sql = "SELECT * FROM users";

		List<User> users = jdbc.query(sql, USER_MAPPER);

		for (var u:users) {
			System.out.println(u);
		}
		sql = "DELETE FROM users WHERE id > 64";
		jdbc.execute(sql);

		sql = "INSERT INTO users (name, email, active) VALUES('','',0)";
		jdbc.execute(sql);

	}
}
