package ua.dp.daragan.sn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.dp.daragan.sn.domain.UserDetails;

/**
 * Created by bogdan on 17.09.16.
 */
@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
}
