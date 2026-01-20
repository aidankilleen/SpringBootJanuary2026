package ie.rc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ie.rc")
public class AppConfig {

    @Bean
    public String getMessage() {
        return "Is the annotation working?";
    }

    @Bean
    public User getUser() {
        return new User(99,
                "Aoife",
                "aoife@gmail.com",
                false);
    }
}
