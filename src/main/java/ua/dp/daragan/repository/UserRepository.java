package ua.dp.daragan.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.dp.daragan.entity.User;

/**
 *
 * @author bogdan
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> { //PagingAndSortingRepository
    
    User findByUsername(String username); 
    List<User> findByUsernameStartsWith(String name, Pageable p);
    List<User> findAll();
}