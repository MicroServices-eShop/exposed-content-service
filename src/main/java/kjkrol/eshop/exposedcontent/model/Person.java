package kjkrol.eshop.exposedcontent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash("person")
public class Person implements Serializable {
    @Id
    private String id;
    private String name;
    private String surname;
    private String bio;
    private List<PersonRole> roles;

    public Person(String id, String name, String surname, String bio, List<PersonRole> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.bio = bio;
        this.roles = roles;
    }

    public Person() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bio='" + bio + '\'' +
                ", roles=" + roles +
                '}';
    }
}
