package trabajopractico2;

import java.util.HashMap;
import java.util.Objects;

public class EpicDoubleHashMap<K extends Number, V, T> {
    HashMap<K, V> map1;
    HashMap<K, T> map2;

    int repeatingCounter = 0;


    public EpicDoubleHashMap() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void addFirstType(K key, V value) throws ExistingKeyException {
        if (map1.containsKey(key)){
            throw new ExistingKeyException("The value with this key already exists");
        }

        map1.put(key, value);
    }

    public void addSecondType(K key, T value) throws ExistingKeyException{
        if (map2.containsKey(key)){
            throw new ExistingKeyException("The value with this key already exists");
        }
        map2.put(key, value);
    }

    public void addTwoType(K key, V value, T value2){
        if (map1.containsValue(value) || map2.containsValue(value2)){
            repeatingCounter++;
        }
        map1.put(key, value);
        map2.put(key, value2);
    }

    public HashMap<K, V> getMap1(){
        return this.map1;
    }

    public HashMap<K, T> getMap2(){
        return this.map2;
    }


    public void getValueFirstMap(K key) throws WrongTypeException {
        System.out.println(map1.get(key));
        emptyMap1Error(key);
    }

    public void getValueSecondMap(K key) throws WrongTypeException {
        System.out.println(map2.get(key));
        emptyMap2Error(key);
    }

    public void getTwoValues(K key){
        System.out.println(key + " - " + map1.get(key) +" - " + map2.get(key));
    }

    public void removeValueFirstMap(K key) throws MissingKeyException{
        if (!map1.containsKey(key)){
            throw new MissingKeyException("The key being requested doesn't exist");
        }
        map1.remove(key);
    }

    public void removeValueSecondMap(K key){
        map2.remove(key);
    }

    public void removeTwoValues(K key){
        map1.remove(key);
        map2.remove(key);
    }


    public void emptyMap1Error(K key)throws WrongTypeException{
            if (map1.get(key) == null){
                throw new WrongTypeException("There is no Value asigned to that key");
            }


    }

    public void emptyMap2Error(K key)throws WrongTypeException{

        if (map2.get(key) == null){
            throw new WrongTypeException("There is no Value asigned to that key");
        }

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EpicDoubleHashMap<?, ?, ?> that)) return false;
        return getMap1().equals(that.getMap1()) && getMap2().equals(that.getMap2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMap1(), getMap2());
    }
}
