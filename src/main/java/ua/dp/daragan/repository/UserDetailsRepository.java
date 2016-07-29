package ua.dp.daragan.repository;

import org.springframework.data.repository.CrudRepository;
import ua.dp.daragan.entity.UserDetails;

/**
 *
 * @author bogdan
 */
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
    
}