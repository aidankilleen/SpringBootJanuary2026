package ie.rc.SpringBootHelloWorld;

import ie.rc.SpringBootHelloWorld.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Value("${app.database.url}")
    String url;

    @Bean
    public String getMessage() {
        return "Message Bean";
    }

    @Bean
    public User getUser() {
        return new User(99, "Kelsey", "kelsey@gmail.com", true);
    }

    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
