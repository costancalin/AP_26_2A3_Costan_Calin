import java.time.LocalDate;

public class Designer extends Person {
    private String softwareType; // canva etc

    public Designer(int id, String name, LocalDate birthDate, String software) {
        super(id, name, birthDate);
        this.softwareType = software;
    }

    @Override
    public String toString() {
        return "Designer: " + name + " [Tool: " + softwareType + "]";
    }
}