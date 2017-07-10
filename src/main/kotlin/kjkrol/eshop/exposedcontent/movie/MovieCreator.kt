package kjkrol.eshop.exposedcontent.movie

import kjkrol.eshop.exposedcontent.model.CastEntry
import kjkrol.eshop.exposedcontent.model.Movie
import org.springframework.stereotype.Service
import java.util.UUID

@Service
internal class MovieCreator(val movieRepository: MovieRepository) {

    fun create(title: String,
               description: String,
               cast: List<CastEntry>): Movie {
        val movie = Movie(UUID.randomUUID().toString(), title, description, cast)
        movieRepository.save(movie)
        return movie
    }
}