package kjkrol.eshop.exposedcontent.castentry

import kjkrol.eshop.exposedcontent.model.CastEntry
import org.springframework.data.repository.CrudRepository


internal interface CastEntryRepository : CrudRepository<CastEntry, String>