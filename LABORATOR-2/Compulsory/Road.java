public class Road
{
    private String type;
    private double length;
    private double speedLimit;
    private Location from;
    private Location to;

    public Road(String type, double length, double speedLimit, Location from, Location to)
    {
        double distance = Math.sqrt(Math.pow(from.getX() - to.getX(), 2) +
                Math.pow(from.getY() - to.getY(), 2));

        if (length < distance)
        {
            throw new IllegalArgumentException("Lungime nevalida.");
        }

        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
        this.from = from;
        this.to = to;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public double getSpeedLimit()
    {
        return speedLimit;
    }

    public void setSpeedLimit(double speedLimit)
    {
        this.speedLimit = speedLimit;
    }

    public Location getFrom()
    {
        return from;
    }

    public void setFrom(Location from)
    {
        this.from = from;
    }

    public Location getTo()
    {
        return to;
    }

    public void setTo(Location to)
    {
        this.to = to;
    }

    @Override
    public String toString()
    {
        return "Road{" +
                "type='" + type + '\'' +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                ", from=" + from.getName() +
                ", to=" + to.getName() +
                '}';
    }
}