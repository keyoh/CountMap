package ru.sbt;

public class Main {

    public static void main(String[] args) {
        CountMap<Integer> countMap = new CountMap<>();
        countMap.add(5);
        countMap.add(5);
        countMap.add(6);
        countMap.add(3);
        countMap.add(1);
        //System.out.println(countMap.getCount(3));
        //System.out.println(countMap.remove(5));
        System.out.println(countMap.size());
        System.out.println(countMap.toMap());
    }
}
