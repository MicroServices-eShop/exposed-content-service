package kjkrol.eshop.exposedcontent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

import static java.util.UUID.randomUUID;

@RedisHash("movie")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Movie {
    @Id
    private String id = randomUUID().toString();
    @Indexed
    private String title;
    private String description;
    @Reference
    private List<CastEntry> cast;

    public Movie(String title, String description, List<CastEntry> cast) {
        this.title = title;
        this.description = description;
        this.cast = cast;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<CastEntry> getCast() {
        return cast;
    }
}
