package main;


import exceptions.ExistingKeyException;
import exceptions.MissingKeyException;
import exceptions.RepeatingException;
import exceptions.WrongTypeException;
import modelclasses.Cat;
import modelclasses.Dog;
import modelclasses.EpicDoubleHashMap;

public class Main {
    public static void main(String[] args) throws ExistingKeyException, MissingKeyException, RepeatingException, WrongTypeException {

        EpicDoubleHashMap<Integer, Integer, String> map = new EpicDoubleHashMap<>();

        // Remove comments to get the exceptions/aux methods

        Dog dog1 = new Dog("Martin", 2);
        Dog dog2 = new Dog("Lautaro",2);
                                                     // Values from another classes to use them
        Cat cat1 = new Cat("Joselin",4);
        Cat cat2 = new Cat("Pepe",10);

        map.addFirstType(1, 10);
        map.addSecondType(2, "Hello");
        map.addTwoType(3, 15, "Bye");

        map.addFirstType(4, 40);
        map.addSecondType(5, "Erased");
        map.addTwoType(6, 99 ,"Also Erased");

        //EXCEPTIONS

        //Exception "a":
        //map.getValueFirstMap(10);

        //Exception "b":
        //map.removeValueFirstMap(10);

        //Exception "c":
        //map.addFirstType(7, 10);
        //map.addFirstType(8, 10);
        //map.addFirstType(9, 10);

        //Exception "d":
        //map.getValueFirstMap(2);

        
        map.getValueFirstMap(4);
        map.getValueSecondMap(5);
        map.getTwoValues(6);
        map.removeValueFirstMap(4);
        map.removeValueSecondMap(5);
        map.removeTwoValues(6);
        System.out.println("-".repeat(50));
        System.out.println("Map 1: " + map.getMap1());
        System.out.println("Map 2: " + map.getMap2());
        //AUX METHODS
        System.out.println("-".repeat(50));
        System.out.println("AUX METHODS: ");

        System.out.print("a: "); map.repeatedValuesType();

        //map.addFirstType(12, 10);
        //map.addFirstType(13, 10);
        System.out.println("b: " + map.valuesEqualToKey(1));

        System.out.println("c: " + map.repeatedValues());







    }
}
