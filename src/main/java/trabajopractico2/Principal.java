package trabajopractico2;

public class Principal {
    public static void main(String[] args) {
        EpicDoubleHashMap<Integer, Integer, String> map = new EpicDoubleHashMap<>();

        map.addFirstType(1, 10);
        map.addSecondType(2, "Hola");
        map.addTwoType(3, 30, "Chau");

        map.getValueFirstMap(1);
        map.getValueSecondMap(2);
        map.getTwoValues(3);

        map.removeTwoValues(3);
        System.out.println(map.getMap1());
        System.out.println(map.getMap2());

    }
}
