package kjkrol.eshop.exposedcontent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

import static java.util.UUID.randomUUID;

@RedisHash("person")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Person implements Serializable {
    @Id
    private String id = randomUUID().toString();
    private String name;
    private String surname;
    private String bio;
    private List<PersonRole> roles;

    public Person(String name, String surname, String bio, List<PersonRole> roles) {
        this.name = name;
        this.surname = surname;
        this.bio = bio;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBio() {
        return bio;
    }

    public List<PersonRole> getRoles() {
        return roles;
    }
}
