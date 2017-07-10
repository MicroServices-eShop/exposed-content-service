package kjkrol.eshop.exposedcontent.movie

import kjkrol.eshop.exposedcontent.model.Movie
import org.springframework.data.repository.CrudRepository


interface MovieRepository : CrudRepository<Movie, String> {
    fun findByTitle(title: String): List<Movie>
}