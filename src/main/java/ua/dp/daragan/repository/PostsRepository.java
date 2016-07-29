package ua.dp.daragan.repository;

import org.springframework.data.repository.CrudRepository;
import ua.dp.daragan.entity.Posts;

/**
 *
 * @author bogdan
 */
public interface PostsRepository extends CrudRepository<Posts, Long>{
    Posts findByPostId(Long id);
}