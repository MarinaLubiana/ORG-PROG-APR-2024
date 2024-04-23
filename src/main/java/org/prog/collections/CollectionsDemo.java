package org.prog.collections;

import org.prog.Car;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {

    /**
     * HOMEWORK 3:
     * using this code print colors and owner names of all cars which plateNumber has 001
     *
     * @param args
     */

    public static void main(String[] args) {
        Map<String, Set<Car>> ownedCars = new HashMap<>();

        Car car1 = new Car();//bob
        car1.color = "red";
        car1.plateNumber = "A001";
        Car car2 = new Car();//bob+alice
        car2.color = "yellow";
        car2.plateNumber = "B002";
        Car car3 = new Car();//bob
        car3.color = "orange";
        car3.plateNumber = "C002";
        Car car4 = new Car();//alice
        car4.color = "green";
        car4.plateNumber = "D001";

        //Set<Car> bobCars = new HashSet<>();
        //bobCars.add(car1);
        // bobCars.add(car2);
        //bobCars.add(car3);
        //Set<Car> aliceCars = new HashSet<>();
        //aliceCars.add(car2);
        //aliceCars.add(car4);
        Set<Car> firstList = new HashSet<>();
        firstList.add(car1);
        firstList.add(car4);
        Set<Car> secondList = new HashSet<>();
        secondList.add(car2);
        secondList.add(car3);

        ownedCars.put("Bob", firstList);
        ownedCars.put("Alise", firstList);


        Set<String> keySet = ownedCars.keySet();
        for (String key : keySet) {
            Set<Car> cars = ownedCars.get(key);
            for (Car c : cars) {
                System.out.println(c.color);
                System.out.println(c.plateNumber);
            }
        }


    }
}