package Task2;

import java.util.HashMap;

public class App2 {
    public static void main(String[] args) throws Exception {
        int[] array1 = {2,3,4,5};
        int[] array2 = {1,3,5,7};
        findDuplicate(array1, array2);
    }

    static void findDuplicate(int[] array1, int[] array2){
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i : array1){
            hash.put(i, 1);
        }
        for(int j : array2){
            if(hash.containsKey(j)){
                System.out.println(j);
            }
        }
    }
}
