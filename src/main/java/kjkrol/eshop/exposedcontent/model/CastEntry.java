package kjkrol.eshop.exposedcontent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.lang.*;

import static java.util.UUID.randomUUID;

@RedisHash("cast-entry")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class CastEntry implements Serializable {
    @Id
    private String id = randomUUID().toString();
    @Reference
    private Person person;
    @Reference
    private Character character;

    public CastEntry(Person person, Character character) {
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
}
