
void main()
{
    System.out.println("Hello World!");


    String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};


    int n = (int) (Math.random() * 1_000_000);


    int rezultat = n * 3;
    rezultat += 0b10101;
    rezultat += 0xFF;
    rezultat *= 6;

// cifra de control
    while (rezultat > 9)
    {
        int suma = 0;
        while (rezultat > 0)
        {
            suma += rezultat % 10;
            rezultat /= 10;
        }
        rezultat = suma;
    }


    System.out.println("Willy-nilly, this semester I will learn " + languages[rezultat]);
}
