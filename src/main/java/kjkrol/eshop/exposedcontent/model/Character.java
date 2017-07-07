package kjkrol.eshop.exposedcontent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

import static java.util.UUID.randomUUID;

@RedisHash("character")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Character implements Serializable {
    @Id
    private String id = randomUUID().toString();
    private String name;
    private String description;

    public Character(String name, String description) {
        this.name = name;
        this.description = description;
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
}
