package ie.rc;

import ie.rc.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("ie.rc")
public class AppConfig {

    @Bean
    public String getMessage() {
        return "Spring Beans Working";
    }

    @Bean
    public User getUser() {
        return new User(1, "Aideen", "aideen@gmail.com", true);
    }

    @Bean
    public Connection getConnection() throws SQLException {

        String url = "jdbc:sqlite:C:\\work\\training\\java\\users.db";
        return DriverManager.getConnection(url);
    }
}
