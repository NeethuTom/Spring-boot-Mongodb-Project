package acc.proj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Controller which handles reqest for saving {@link User}s.
 *
 * @author Neethu Tom
 */
@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * The method saves the user details
     * @param name
     * @param userName
     * @param password
     * @param email
     * @param email
     * @return to demo page
     */
    @PostMapping(value = "/save")
    public String save(@RequestParam("name") String name,
                       @RequestParam("userName") String userName,
                       @RequestParam("password") String password,
                       @RequestParam("role") String role,
                       @RequestParam("email") String email) {

        User user = new User(name, userName, password, email,role);
        userRepository.save(user);

        return "redirect:/";


    }

    /**
     * This method is for updating user details
     * @param id
     * @param name
     * @param userName
     * @param password
     * @param role
     * @param email
     * @return the update success page
     */
    @PostMapping(value = "/update")
    public String update(@RequestParam("id") String id,
                        @RequestParam("name") String name,
                       @RequestParam("userName") String userName,
                       @RequestParam("password") String password,
                         @RequestParam("role") String role,
                       @RequestParam("email") String email) {

        User user = new User(name, userName, password, email,role);
        userRepository.delete(id);
        userRepository.save(user);

        return "redirect:/updatesuccess";

    }


    /**
     * This method is to delete the user by admin
     * @param idfordelete
     * @return to demo page
     */
    @PostMapping(value = "/deleteUsers")
    public String update(@RequestParam("idfordelete") String idfordelete) {
        userRepository.delete(idfordelete);

        return "redirect:/";

    }

}

