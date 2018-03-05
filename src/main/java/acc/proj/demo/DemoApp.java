package acc.proj.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main Application controller.
 *
 * @author Neethu Tom
 */
@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages = "acc.proj.*")
public class DemoApp {

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }

    /**
     * This returns index.html
     * for demo page loading
     * @return index.html
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * This is for loading login page
     */
    @RequestMapping("/home")
    public String home() {
        return "user-data";
    }

    /**
     * This is for loading update success page
     */
    @RequestMapping("/updatesuccess")
    public String updatesuccess() {
        return "update-success";
    }
}
