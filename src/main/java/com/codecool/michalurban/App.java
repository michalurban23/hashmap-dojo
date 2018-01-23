package com.codecool.michalurban;

import com.codecool.michalurban.map.HashMap;

public class App {

    public static void main( String[] args ) {

        HashMap map = new HashMap();

        map.add("ala", 1);
        map.add("ma", 2);
        map.add("kota", 3);
        map.add("zosia", 4);
        map.add("ma", 5);
        map.add("psa", 6);
        map.add("basia", 7);
        map.add("ma", 8);
        map.add("konia", 9);

        System.out.println(map.getValue("ala"));
        System.out.println(map.getValue("ma"));
        System.out.println(map.getValue("konia"));
        System.out.println(map.getValue("..."));

        map.remove("ala");
        System.out.println(map.getValue("ala"));
        System.out.println(map.getValue("zosia"));

        map.clearAll();
        System.out.println("ma");
    }
}
