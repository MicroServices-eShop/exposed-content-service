package kjkrol.eshop.exposedcontent.character

import kjkrol.eshop.exposedcontent.model.Character
import org.springframework.stereotype.Service
import java.util.UUID

@Service
internal class CharacterCreator(val characterRepository: CharacterRepository) {

    fun create(name: String,
               description: String): Character {
        val character = Character(UUID.randomUUID().toString(), name, description)
        characterRepository.save(character)
        return character
    }

}