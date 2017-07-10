package kjkrol.eshop.exposedcontent.castentry

import kjkrol.eshop.exposedcontent.model.CastEntry
import org.springframework.stereotype.Service

@Service
internal class CastEntryQuery(val castEntryRepository: CastEntryRepository) {

    fun findByCastEntryId(id: String): CastEntry {
        return castEntryRepository.findOne(id)
    }

}