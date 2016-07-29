package ua.dp.daragan.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ua.dp.daragan.entity.Posts;
import ua.dp.daragan.entity.User;

/**
 *
 * @author bogdan
 */
public interface PostsRepository extends PagingAndSortingRepository<Posts, Long>{
    Posts findByPostId(Long id);
    List<Posts> findByUser(User user);
    List<Posts> findByUser(User user, Pageable pageable);
}