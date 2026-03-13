import java.util.*;

public class Company implements Profile, Comparable<Company> {
    private int id;
    private String name;
    private String industry;
    private List<Person> employees = new ArrayList<>();

    public Company(int id, String name, String industry) {
        this.id = id;
        this.name = name;
        this.industry = industry;
    }

    public void addEmployee(Person p) {
        employees.add(p);
    }

    public int getEmployeeCount() {
        return employees.size();
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getId() { return id; }

    @Override
    public int compareTo(Company other) {
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
        return "Compania: " + name + " (Domeniu: " + industry + ")";
    }
}