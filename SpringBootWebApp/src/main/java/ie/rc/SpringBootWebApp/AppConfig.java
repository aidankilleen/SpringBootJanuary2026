package ie.rc.SpringBootWebApp;

import ie.rc.SpringBootWebApp.models.User;
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
    String getMessage() {
        return "This is a message from a bean";
    }

    @Bean
    User getUser() {
        return new User(1,
                "Alice",
                "alice@gmail.com",
                true);
    }

    @Bean
    Connection getConnection() throws SQLException {

        //var url = "jdbc:sqlite:C:\\work\\training\\java\\users.db";
        return DriverManager.getConnection(url);
    }
}
