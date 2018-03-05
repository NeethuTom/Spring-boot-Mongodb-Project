package acc.proj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Controller which handles reqest for saving {@link User}s.
 *
 * @author Neethu Tom
 */
@Controller
public class LoginController {
    private final LoginRepository loginRepository;

    @Autowired
    public LoginController(final LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    /**
     * This is the method for authentication check
     * @param userName
     * @param password
     * @return the user data
     */
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public ModelAndView login(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password)
    {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList= loginRepository.findByUserNameAndPassword(userName,password);

        User user= userList.get(0);
        modelAndView.setViewName("login-data");
        modelAndView.addObject("user", user);
        return modelAndView;
    }


}

