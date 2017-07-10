package kjkrol.eshop.exposedcontent.person

import kjkrol.eshop.exposedcontent.model.Person
import org.springframework.data.repository.CrudRepository


internal interface PersonRepository : CrudRepository<Person, String>