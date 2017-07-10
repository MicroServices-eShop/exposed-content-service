package kjkrol.eshop.exposedcontent.person

import kjkrol.eshop.exposedcontent.model.Person
import org.springframework.stereotype.Service

@Service
internal class PersonQuery(val personRepository: PersonRepository) {

    fun findPersonById(id: String): Person {
        return personRepository.findOne(id)
    }
}
