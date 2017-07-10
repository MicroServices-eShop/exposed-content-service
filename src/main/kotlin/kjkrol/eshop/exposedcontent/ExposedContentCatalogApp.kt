package kjkrol.eshop.exposedcontent


import com.fasterxml.jackson.module.kotlin.KotlinModule
import kjkrol.eshop.exposedcontent.castentry.CastEntryCreator
import kjkrol.eshop.exposedcontent.castentry.CastEntryQuery
import kjkrol.eshop.exposedcontent.castentry.CastEntryRepository
import kjkrol.eshop.exposedcontent.character.CharacterCreator
import kjkrol.eshop.exposedcontent.character.CharacterQuery
import kjkrol.eshop.exposedcontent.character.CharacterRepository
import kjkrol.eshop.exposedcontent.model.PersonRole
import kjkrol.eshop.exposedcontent.movie.MovieCreator
import kjkrol.eshop.exposedcontent.movie.MovieQuery
import kjkrol.eshop.exposedcontent.movie.MovieRepository
import kjkrol.eshop.exposedcontent.person.PersonCreator
import kjkrol.eshop.exposedcontent.person.PersonQuery
import kjkrol.eshop.exposedcontent.person.PersonRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import org.springframework.beans.factory.DisposableBean
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import springfox.documentation.swagger2.annotations.EnableSwagger2


fun main(args: Array<String>) {
    SpringApplication.run(ExposedContentCatalogCatalogApp::class.java, *args)
}

@EnableSwagger2
//@EnableEurekaClient
@SpringBootApplication
open class ExposedContentCatalogCatalogApp {

    companion object {
        val log: Logger = getLogger(ExposedContentCatalogCatalogApp::class.java)
    }

    @Bean
    open fun objectMapperBuilder(): Jackson2ObjectMapperBuilder {
        val mapperBuilder: Jackson2ObjectMapperBuilder = Jackson2ObjectMapperBuilder()
        mapperBuilder.modulesToInstall(KotlinModule())
        mapperBuilder.featuresToEnable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT)
        return mapperBuilder
    }

    @Bean
    internal fun runner(personCreator: PersonCreator,
                        characterCreator: CharacterCreator,
                        castEntryCreator: CastEntryCreator,
                        movieCreator: MovieCreator,
                        personQuery: PersonQuery,
                        characterQuery: CharacterQuery,
                        castEntryQuery: CastEntryQuery,
                        movieQuery: MovieQuery): CommandLineRunner = CommandLineRunner {
        val person = personCreator.create(
                name = "Owen",
                surname = "Wilson",
                bio = "Self-proclaimed troublemaker Owen Wilson was born in Dallas, to Irish-American parents originally from Massachusetts. He grew up in Texas",
                roles = listOf(PersonRole.ACTOR, PersonRole.PRODUCER, PersonRole.WRITER)
        )

        val character = characterCreator.create(
                name = "Lightning McQueen",
                description = "Lightning McQueen is the main protagonist of the Cars franchise. He is the deuteragonist of Cars Toons: Mater's Tall Tales. He is Mater's best friend and Sally's boyfriend."
        )

        val castEntry = castEntryCreator.create(
                person = person,
                character = character)

        val movie = movieCreator.create(
                title = "Cars 3",
                description = "Car racing family movie.",
                cast = listOf(castEntry)
        )

        val foundPerson = personQuery.findPersonById(person.id)
        log.info("found Person={}", foundPerson)
        val foundCharacter = characterQuery.findCharacterById(character.id)
        log.info("found Character={}", foundCharacter)
        val foundCastEntry = castEntryQuery.findByCastEntryId(castEntry.id)
        log.info("found CastEntry={}", foundCastEntry)
        val foundMovie = movieQuery.findByMovieId(movie.id)
        log.info("found Movie={}", foundMovie)
        val foundMovieByTile = movieQuery.findByTitle(movie.title)
        log.info("found by title Movie={}", foundMovieByTile)
    }


    @Bean
    internal fun disposableBean(movieRepository: MovieRepository,
                                personRepository: PersonRepository,
                                characterRepository: CharacterRepository,
                                castEntryRepository: CastEntryRepository): DisposableBean = DisposableBean {
        movieRepository.deleteAll()
        castEntryRepository.deleteAll()
        personRepository.deleteAll()
        characterRepository.deleteAll()
        log.info("Cleanup Redis db after session")
    }

}






