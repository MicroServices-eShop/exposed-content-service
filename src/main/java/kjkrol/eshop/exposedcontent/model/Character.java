package kjkrol.eshop.exposedcontent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("character")
public class Character implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;

    public Character(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Character() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        return id.equals(character.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
