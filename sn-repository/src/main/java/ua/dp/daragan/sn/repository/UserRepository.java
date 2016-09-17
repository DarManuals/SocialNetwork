package ua.dp.daragan.sn.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.dp.daragan.sn.domain.User;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by bogdan on 17.09.16.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);
    List<User> findByUsernameStartsWith(String name, Pageable p);
}
