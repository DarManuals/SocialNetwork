package ua.dp.daragan.sn.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.dp.daragan.sn.domain.Posts;
import ua.dp.daragan.sn.domain.User;

import java.util.List;

/**
 * Created by bogdan on 17.09.16.
 */
@Repository
public interface PostsRepository extends PagingAndSortingRepository<Posts, Long> {
    Posts findByPostId(Long id);
    List<Posts> findByUser(User user);
    List<Posts> findByUser(User user, Pageable pageable);
}