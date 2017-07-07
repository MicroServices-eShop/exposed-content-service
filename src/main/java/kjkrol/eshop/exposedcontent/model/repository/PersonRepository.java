package kjkrol.eshop.exposedcontent.model.repository;

import kjkrol.eshop.exposedcontent.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}
