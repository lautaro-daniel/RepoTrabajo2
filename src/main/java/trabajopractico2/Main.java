package trabajopractico2;


public class Main {
    public static void main(String[] args) throws ExistingKeyException, MissingKeyException, RepeatingException, WrongTypeException {

        EpicDoubleHashMap<Integer, Integer, String> map = new EpicDoubleHashMap<>();

        map.addFirstType(1, 10);
       // map.addFirstType(2, 10);
       // map.addFirstType(3, 10);
        //map.addFirstType(4, 10);
        //map.addSecondType(2, "Hello");

        map.addTwoType(3, 30, "Bye");


        map.getValueFirstMap(1);

        map.getValueSecondMap(2);
        map.getTwoValues(3);
        //map.removeTwoValues(3);
        System.out.println(map.valuesEqualToKey(1));
        System.out.println(map.repeatedValues(10));
        //map.repeatedValues(10);
        System.out.println(map.getMap1());
        System.out.println(map.getMap2());







    }
}
