package trabajopractico2;

import java.util.HashMap;

public class EpicDoubleHashMap<K extends Number, V, T> {
    HashMap<K, V> map1;
    HashMap<K, T> map2;

    public EpicDoubleHashMap() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void addFirstType(K key, V value) {
        map1.put(key, value);
    }

    public void addSecondType(K key, T value){
        map2.put(key, value);
    }

    public void addTwoType(K key, V value, T value2){
        map1.put(key, value);
        map2.put(key, value2);
    }

    public HashMap<K, V> getMap1(){
        return this.map1;
    }

    public HashMap<K, T> getMap2(){
        return this.map2;
    }

    public void getValueFirstMap(K key){
        System.out.println(map1.get(key));
    }

    public void getValueSecondMap(K key){
        System.out.println(map2.get(key));
    }

    public void getTwoValues(K key){
        System.out.println(key + " - " + map1.get(key) +" - " + map2.get(key));
    }

    public void removeValueFirstMap(K key){
        map1.remove(key);
    }

    public void removeValueSecondMap(K key){
        map2.remove(key);
    }

    public void removeTwoValues(K key){
        map1.remove(key);
        map2.remove(key);
    }

}
