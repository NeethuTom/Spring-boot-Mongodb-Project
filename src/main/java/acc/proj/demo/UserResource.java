package acc.proj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller which is responsible for retrieving {@link User}s.
 *
 * @author Neethu Tom
 */
@RestController
@RequestMapping(value = "/api/users")
public class UserResource {

    private final UserRepository userRepository;

    @Autowired
    public UserResource(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * To fetch details of all users
     * @return user list
     */
    @GetMapping(produces = "application/JSON")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    /**
     *This method fetches the details of user for
     * url localhost:port/api/users/<userid>
     *  This method is written only for illustrating
     *  rest Api JSON
     *  Not included in requirement
     */
    @GetMapping(value = "/{id}", produces = "application/JSON")
    public User findById(@PathVariable("id") String userID) {
        return userRepository.findOne(userID);
    }
}
