package kjkrol.eshop.exposedcontent.character

import kjkrol.eshop.exposedcontent.model.Character
import org.springframework.stereotype.Service

@Service
internal class CharacterQuery(val characterRepository: CharacterRepository) {

    fun findCharacterById(id: String): Character {
        return characterRepository.findOne(id)
    }

}