package org.example;
public class Street implements Comparable<Street> {
    private String name;
    private int length;
    private Intersection i1, i2;

    public Street(String name, int length, Intersection i1, Intersection i2) {
        this.name = name;
        this.length = length;
        this.i1 = i1;
        this.i2 = i2;
    }

    public int getLength() { return length; }

    @Override
    public int compareTo(Street other) {
        return Integer.compare(this.length, other.length);
    }

    @Override
    public String toString() {
        return name + " (" + length + "m) intre " + i1 + " si " + i2;
    }
}