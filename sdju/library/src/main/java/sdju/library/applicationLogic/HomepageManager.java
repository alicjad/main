package sdju.library.applicationLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sdju.library.repositories.UserDbRepository;
import sdju.library.model.User;

import java.sql.SQLException;

@Component
public class HomepageManager {


    private UserDbRepository userRepository;

    @Autowired
    public HomepageManager(@Qualifier("getUserDbRepository") UserDbRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method checks if entered userdata matches data saved in a database
     * @param checkedUser User object which save username and password entered by a user
     * @return
     * 1 if checked user's data match saved user data
     * 0 if an exception was thrown
     * -1 if password doesn't match, or entered password is empty
     * -2 if user with such username wasn't found or username is empty
     */
    public byte login(User checkedUser){
        if (checkedUser.getPassword().isEmpty()) return -1;
        if (checkedUser.getUsername().isEmpty()) return -2;

        User savedUser;
        try {
            savedUser = userRepository.read(checkedUser.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        if (savedUser == null){
            return -2;
        }
        if(checkedUser.getPassword().equals(savedUser.getPassword())){
            checkedUser.setUserId(savedUser.getUserId());
            return 1;
        }
        return -1;
    }


    /**
     * This method is used to save a new user in a repository
     * @param user User object that should be saved
     * @return
     * 1 if saving was successful,
     * 0 if an exception was thrown,
     * -1 if entered password is empty,
     * -2 if username is empty or already taken
     *
     */
    public byte register(User user){
        if (user.getPassword().isEmpty()) return -1;
        if (user.getUsername().isEmpty()) return -2;

        try {
            if (userRepository.read(user.getUsername()) != null){
                return -2;
            }
            userRepository.create(user);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
