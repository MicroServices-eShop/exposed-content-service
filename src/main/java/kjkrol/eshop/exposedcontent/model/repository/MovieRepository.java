package kjkrol.eshop.exposedcontent.model.repository;

import kjkrol.eshop.exposedcontent.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, String> {
    List<Movie> findByTitle(String title);
}





