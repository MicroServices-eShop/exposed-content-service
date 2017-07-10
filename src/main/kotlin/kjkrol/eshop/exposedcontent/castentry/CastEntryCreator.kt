package kjkrol.eshop.exposedcontent.castentry

import kjkrol.eshop.exposedcontent.model.CastEntry
import kjkrol.eshop.exposedcontent.model.Character
import kjkrol.eshop.exposedcontent.model.Person
import org.springframework.stereotype.Service
import java.util.UUID

@Service
internal class CastEntryCreator(val castEntryRepository: CastEntryRepository) {

    fun create(person: Person,
               character: Character): CastEntry {
        val castEntry = CastEntry(UUID.randomUUID().toString(), person, character)
        castEntryRepository.save(castEntry)
        return castEntry
    }
}