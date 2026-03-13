package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Intersection> intersectionList = IntStream.range(0, 10)
                .mapToObj(i -> new Intersection("Intersection " + i))
                .collect(Collectors.toList());


        Set<Intersection> intersectionSet = new HashSet<>(intersectionList);


        intersectionSet.add(new Intersection("Intersection 0"));
        System.out.println("Numar intersectii distincete in Set : " + intersectionSet.size());


        LinkedList<Street> streets = new LinkedList<>();
        streets.add(new Street("Street A", 500, intersectionList.get(0), intersectionList.get(1)));
        streets.add(new Street("Street B", 200, intersectionList.get(1), intersectionList.get(2)));
        streets.add(new Street("Street C", 800, intersectionList.get(2), intersectionList.get(3)));
        streets.add(new Street("Street D", 100, intersectionList.get(0), intersectionList.get(3)));


        streets.sort((s1, s2) -> Integer.compare(s1.getLength(), s2.getLength()));


        System.out.println("\nStrazi sortate dupa lg:");
        streets.forEach(System.out::println);
    }
}