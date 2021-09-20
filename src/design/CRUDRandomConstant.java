package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class CRUDRandomConstant {
    public static void main(String[] args) {
        CRUDRandomConstant ds = new CRUDRandomConstant();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
    }

    ArrayList<Integer> arr;   // A resizable array
    HashMap<Integer, Integer> hash;

    public CRUDRandomConstant() {
        arr = new ArrayList<Integer>();
        hash = new HashMap<Integer, Integer>();
    }

    void add(int x) {
        if (hash.get(x) != null){
            return;
        }
        int s = arr.size();
        arr.add(x);
        hash.put(x, s);
    }

    void remove(int x) {
        // Check if element is present
        Integer index = hash.get(x);
        if (index == null) {
            return;
        }
        hash.remove(x);
        // Swap element with last element so that remove from
        // arr[] can be done in O(1) time
        int size = arr.size();
        Integer last = arr.get(size - 1);
        Collections.swap(arr, index, size - 1);
        // Remove last element (This is O(1))
        arr.remove(size - 1);

        // Update hash table for new index of last element
        hash.put(last, index);
    }

    // Returns a random element from MyDS
    int getRandom() {
        int index =  new Random().nextInt(arr.size());
        // Return element at randomly picked index
        return arr.get(index);
    }

    // Returns index of element if element is present, otherwise null
    Integer search(int x) {
        return hash.get(x);
    }
}
