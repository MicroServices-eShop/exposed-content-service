package kjkrol.eshop.exposedcontent.movie

import kjkrol.eshop.exposedcontent.model.Movie
import org.springframework.stereotype.Service

@Service
internal class MovieQuery(val movieRepository: MovieRepository) {

    fun findByMovieId(id: String): Movie {
        return movieRepository.findOne(id)
    }

    fun findByTitle(title: String): List<Movie> {
        return movieRepository.findByTitle(title)
    }
}