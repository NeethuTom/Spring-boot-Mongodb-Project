package acc.proj.demo;

import org.springframework.data.repository.Repository;
import java.util.List;

/**
 * Repository for saving new and retrieving existing {@link User}s from MongoDB
 *
 * @author Neethu Tom
 */
public interface LoginRepository extends Repository<User, Long> {

    List<User> findByUserNameAndPassword(String userName, String password);
}
