import java.time.LocalDate;

public class Programmer extends Person {
    private String mainLanguage;

    public Programmer(int id, String name, LocalDate birthDate, String language) {
        super(id, name, birthDate);
        this.mainLanguage = language;
    }

    @Override
    public String toString() {
        return "Programmer: " + name + " [Language: " + mainLanguage + "]";
    }
}