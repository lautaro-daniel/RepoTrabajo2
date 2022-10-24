package modelclasses;

import exceptions.ExistingKeyException;
import exceptions.MissingKeyException;
import exceptions.RepeatingException;
import exceptions.WrongTypeException;

import java.util.HashMap;
import java.util.Map;

public class EpicDoubleHashMap<K extends Number, V, T> {
    HashMap<K, V> map1;
    HashMap<K, T> map2;

    public EpicDoubleHashMap() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void addFirstType(K key, V value) throws ExistingKeyException, RepeatingException {
        if (map1.containsKey(key)) {
            throw new ExistingKeyException("The value with this key already exists");
        }
        map1.put(key, value);
        threeValuesRepeated(value);
    }

    public void addSecondType(K key, T value) throws ExistingKeyException, RepeatingException {
        if (map2.containsKey(key)) {
            throw new ExistingKeyException("The value with this key already exists");
        }
        map2.put(key, value);
        threeValuesRepeated(value);
    }

    public void addTwoType(K key, V value, T value2) {
        map1.put(key, value);
        map2.put(key, value2);
    }

    public HashMap<K, V> getMap1() {
        return this.map1;
    }

    public HashMap<K, T> getMap2() {
        return this.map2;
    }


    public void getValueFirstMap(K key) throws WrongTypeException {
        System.out.println("Value in key " + key +": " +  map1.get(key));
        emptyMap1Error(key);
    }

    public void getValueSecondMap(K key) throws WrongTypeException {
        System.out.println("Value in key " + key +": " + map2.get(key));
        emptyMap2Error(key);
    }

    public void getTwoValues(K key) {
        System.out.println("Values in key " + key + ": " + map1.get(key) + " - " + map2.get(key));
    }

    public void removeValueFirstMap(K key) throws MissingKeyException {
        if (!map1.containsKey(key)) {
            throw new MissingKeyException("The key being requested doesn't exist");
        }
        map1.remove(key);
    }

    public void removeValueSecondMap(K key) throws MissingKeyException {
        if (!map2.containsKey(key)) {
            throw new MissingKeyException("The key being requested doesn't exist");
        }
        map2.remove(key);
    }

    public void removeTwoValues(K key) throws MissingKeyException {
        if (!map2.containsKey(key) || !map1.containsKey(key)) {
            throw new MissingKeyException("The key being requested doesn't exist");
        }
        map1.remove(key);
        map2.remove(key);
    }


    public void emptyMap1Error(K key) throws WrongTypeException {
        if (map1.get(key) == null) {
            throw new WrongTypeException("There is no Value asigned to that key");
        }


    }

    public void emptyMap2Error(K key) throws WrongTypeException {

        if (map2.get(key) == null) {
            throw new WrongTypeException("There is no Value asigned to that key");
        }

    }

    public void threeValuesRepeated(Object value) throws RepeatingException {
        int count = -1;
        for (Map.Entry<K, V> entry : map1.entrySet()) {
            if (value.equals(entry.getValue())) {
                count += 1;
            }
        }
        for (Map.Entry<K, T> entry : map2.entrySet()) {
            if (value.equals(entry.getValue())) {
                count += 1;
            }
        }
        if (count >= 3){
            throw new RepeatingException("A value is repeating 3 or more times");
        }
    }

    public void repeatedValuesType() {
        int count1 = 0, count2 = 0;
        for (Map.Entry<K, V> entry : map1.entrySet()) {
            count1 += 1;
        }
        for (Map.Entry<K, T> entry : map2.entrySet()) {
            count2 += 1;
        }

        if (count1 > count2) {
            System.out.println("The amount of V values is greater than the amount of T values");
        } else if (count2 > count1) {
            System.out.println("The amount of T values is greater than the amount of V values");
        } else {
            System.out.println("There are the same number of values");
        }
    }

    public int valuesEqualToKey(K key) {
        int count = 0;
        for (Map.Entry<K, V> entry : map1.entrySet()) {
            if (entry.getValue().equals(map1.get(key))) {
                count += 1;
            }
        }
        for (Map.Entry<K, T> entry : map2.entrySet()) {
            if (entry.getValue().equals(map2.get(key))) {
                count += 1;
            }
        }
        return count;
    }

    public boolean repeatedValues(){
        for (Map.Entry<K, V> entry : map1.entrySet()) {
            for (Map.Entry<K, V> entry1 : map1.entrySet()) {
                if (!entry.getKey().equals(entry1.getKey()) && entry.getValue().equals(entry1.getValue())){
                    return true;
                }
            }
        }
        for (Map.Entry<K, T> access : map2.entrySet()) {
            for (Map.Entry<K, T> entry : map2.entrySet()) {
                if (!access.getKey().equals(entry.getKey())&&access.getValue().equals(entry.getValue())){
                    return true;
                }
            }
        }
        for (Map.Entry<K, V> access : map1.entrySet()) {
            for (Map.Entry<K, T> entry : map2.entrySet()) {
                if (!access.getKey().equals(entry.getKey())&&access.getValue().equals(entry.getValue())){
                    return true;
                }
            }
        }
        return false;
    }

}
