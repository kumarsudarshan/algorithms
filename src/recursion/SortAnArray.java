package recursion;

import java.util.ArrayList;

public class SortAnArray {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(5);
        list.add(15);
        list.add(1);
        list.add(0);
        list.add(2);
        list.add(17);
        System.out.println(list);
        sort(list);
        System.out.println(list);
    }

    static void sort(ArrayList<Integer> list){
        if(list.size() <= 1){
            return;
        }
        int temp = list.get(list.size() - 1);
        list.remove(list.size()-1);
        sort(list);
        insert(list, temp);
    }

    private static void insert(ArrayList<Integer> list, int temp) {
        if(list.size() == 0 || list.get(list.size()-1) <= temp){
            list.add(temp);
            return;
        }
        int val = list.get(list.size()-1);
        list.remove(list.size()-1);
        insert(list, temp);
        list.add(val);
    }

}
