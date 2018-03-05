package acc.proj.demo;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository for saving new and retrieving existing {@link User}s from MongoDB
 *
 * @author Neethu Tom
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
