public class Main
{
  void main()
  {
    Location l1 = new Location("Iasi", "City", 0, 0);
    Location l2 = new Location("Vaslui", "City", 0, 70);
    Location l3 = new Location("OMV", "Gas Station", 10, 10);

    l1.setName("Iasi Centru");
    l3.setType("Gas Station & Shop");

    System.out.println(l1);
    System.out.println(l2);
    System.out.println(l3);

    try
    {
      Road r1 = new Road("Highway", 75.0, 130.0, l1, l2);
      Road r2 = new Road("Country", 20.0, 50.0, l1, l3);

      r1.setSpeedLimit(140.0);
      r1.setType("Expressway");
      r2.setLength(25.5);

      System.out.println(r1);
      System.out.println(r2);
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("Eroare: " + e.getMessage());
    }
  }
}