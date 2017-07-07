package kjkrol.eshop.exposedcontent.model.repository;

import kjkrol.eshop.exposedcontent.model.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, String> {
}
