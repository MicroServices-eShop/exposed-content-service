package kjkrol.eshop.exposedcontent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("cast-entry")
public class CastEntry implements Serializable {
    @Id
    private String id;
    @Reference
    private Person person;
    @Reference
    private Character character;

    public CastEntry() {
    }

    public CastEntry(String id, Person person, Character character) {
        this.id = id;
        this.person = person;
        this.character = character;
    }

    public String getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public Character getCharacter() {
        return character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CastEntry castEntry = (CastEntry) o;

        return id != null ? id.equals(castEntry.id) : castEntry.id == null;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "CastEntry{" +
                "id='" + id + '\'' +
                ", person=" + person +
                ", character=" + character +
                '}';
    }
}
