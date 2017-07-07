package kjkrol.eshop.exposedcontent


import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.module.kotlin.KotlinModule
import kjkrol.eshop.exposedcontent.model.Character
import kjkrol.eshop.exposedcontent.model.CastEntry
import kjkrol.eshop.exposedcontent.model.Movie
import kjkrol.eshop.exposedcontent.model.Person
import kjkrol.eshop.exposedcontent.model.PersonRole
import kjkrol.eshop.exposedcontent.model.repository.CastEntryRepository
import kjkrol.eshop.exposedcontent.model.repository.CharacterRepository
import kjkrol.eshop.exposedcontent.model.repository.MovieRepository
import kjkrol.eshop.exposedcontent.model.repository.PersonRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import springfox.documentation.swagger2.annotations.EnableSwagger2


fun main(args: Array<String>) {
    SpringApplication.run(ExposedContentCatalogCatalogApp::class.java, *args)
}

@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
open class ExposedContentCatalogCatalogApp {

    companion object {
        val log: Logger = getLogger(ExposedContentCatalogCatalogApp::class.java)
    }

    @Bean
    internal fun kotlinModule(): Module {
        return KotlinModule()
    }

    @Bean
    internal fun runner(movieRepository: MovieRepository,
                        personRepository: PersonRepository,
                        characterRepository: CharacterRepository,
                        castEntryRepository: CastEntryRepository): CommandLineRunner {
        return CommandLineRunner {
            val person = Person(
                    "Owen",
                    "Wilson",
                    "Self-proclaimed troublemaker Owen Wilson was born in Dallas, to Irish-American parents originally from Massachusetts. He grew up in Texas",
                    listOf(PersonRole.ACTOR, PersonRole.PRODUCER, PersonRole.WRITER)
            )
            personRepository.save(person)

            val character = Character(
                    "Lightning McQueen",
                    "Lightning McQueen is the main protagonist of the Cars franchise. He is the deuteragonist of Cars Toons: Mater's Tall Tales. He is Mater's best friend and Sally's boyfriend."
            )
            characterRepository.save(character)

            val castEntry = CastEntry(
                    person,
                    character)
            castEntryRepository.save(castEntry)

            val movie = Movie(
                    "Cars 3",
                    "Car racing family movie.",
                    listOf(castEntry)
            )
            movieRepository.save(movie)

            val foundPerson = personRepository.findOne(person.id)
            log.info("found Person={}", foundPerson)
            val foundCharacter = characterRepository.findOne(character.id)
            log.info("found Character={}", foundCharacter)
            val foundCastEntry = castEntryRepository.findOne(castEntry.id)
            log.info("found CastEntry={}", foundCastEntry)
            val foundMovie = movieRepository.findOne(movie.id)
            log.info("found Movie={}", foundMovie)

            val foundMovieByTile = movieRepository.findByTitle(movie.title)
            log.info("found by title Movie={}", foundMovieByTile)
        }
    }
}






