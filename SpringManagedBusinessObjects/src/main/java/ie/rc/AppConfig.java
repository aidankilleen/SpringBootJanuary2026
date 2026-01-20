package ie.rc;

import ie.rc.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("ie.rc")
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Value("${database.url}")
    private String url;

    @Value("${app.message}")
    private String message;

    @Bean
    public String getMessage() {
        return message;
    }

    @Bean
    public User getUser() {
        return new User(1, "Aideen", "aideen@gmail.com", true);
    }

    @Bean
    public Connection getConnection() throws SQLException {

        //String url = "jdbc:sqlite:C:\\work\\training\\java\\users.db";
        return DriverManager.getConnection(url);
    }
}
