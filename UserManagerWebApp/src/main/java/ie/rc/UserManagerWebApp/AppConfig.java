package ie.rc.UserManagerWebApp;

import ie.rc.daos.SqlUserDao;
import ie.rc.daos.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Value("${spring.datasource.url}")
    String url;

    @Bean
    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    @Bean
    UserDao getDao() throws SQLException {

        return new SqlUserDao(getConnection());
    }

}
