package kjkrol.eshop.exposedcontent.person

import kjkrol.eshop.exposedcontent.model.Person
import kjkrol.eshop.exposedcontent.model.PersonRole
import org.springframework.stereotype.Service
import java.util.UUID

@Service
internal class PersonCreator(val personRepository: PersonRepository) {

    fun create(name: String,
               surname: String,
               bio: String,
               roles: List<PersonRole>): Person {
        val person = Person(UUID.randomUUID().toString(), name, surname, bio, roles)
        return personRepository.save(person)
    }

}