package sdju.library.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sdju.library.applicationLogic.HomepageManager;
import sdju.library.repositories.UserDbRepository;

import java.sql.SQLException;

@Configuration
public class ApplicationConfig {

//    @Bean
//    public DBConnector getConnector() throws SQLException {
//        return new DBConnector();
//    }

    @Bean
    public UserDbRepository getUserDbRepository() {
        return new UserDbRepository();
    }
    @Bean
    public HomepageManager getHomepageManager() {
        return new HomepageManager(this.getUserDbRepository());
    }

}
