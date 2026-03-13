import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();

        Programmer p1 = new Programmer(1, "Andrei", LocalDate.of(1995, 1, 1), "Java");
        Designer p2 = new Designer(2, "Elena", LocalDate.of(1998, 5, 5), "Adobe XD");
        Person p3 = new Person(3, "Mihai", LocalDate.of(1990, 1, 1));
        Company c1 = new Company(10, "Ubisoft", "Gaming");

        sn.addProfile(p1);
        sn.addProfile(p2);
        sn.addProfile(p3);
        sn.addProfile(c1);

        p2.addRelationship(p1, "prieteni");
        p1.addRelationship(c1, "angajat");
        c1.addEmployee(p1);
        p3.addRelationship(c1, "client");

        sn.printNetwork();
        sn.findCriticalNodes();
    }
}