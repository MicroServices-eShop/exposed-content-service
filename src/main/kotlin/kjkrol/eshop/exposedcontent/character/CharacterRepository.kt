package kjkrol.eshop.exposedcontent.character

import kjkrol.eshop.exposedcontent.model.Character
import org.springframework.data.repository.CrudRepository


internal interface CharacterRepository : CrudRepository<Character, String>