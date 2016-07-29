package ua.dp.daragan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.dp.daragan.entity.User;

/**
 *
 * @author bogdan
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
    User findByUsername(String username);   
}