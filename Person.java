import java.time.LocalDate;
import java.util.*;

public class Person implements Profile, Comparable<Person> {
    protected int id;
    protected String name;
    protected LocalDate birthDate;
    protected Map<Profile, String> relationships = new HashMap<>();

    public Person(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Map<Profile, String> getRelationships() {
        return relationships;
    }

    public void addRelationship(Profile p, String description) {
        relationships.put(p, description);
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getId() { return id; }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        return id == ((Profile) o).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Persoana: " + name + " (ID: " + id + ")";
    }
}