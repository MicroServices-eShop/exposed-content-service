package kjkrol.eshop.exposedcontent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

@RedisHash("movie")
public class Movie {
    @Id
    private String id;
    @Indexed
    private String title;
    private String description;
    @Reference
    private List<CastEntry> cast;

    public Movie(String id, String title, String description, List<CastEntry> cast) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.cast = cast;
    }

    public Movie() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return id.equals(movie.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cast=" + cast +
                '}';
    }
}
