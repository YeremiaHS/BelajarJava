package Task3;

import java.util.Arrays;

public class App3 {
    public static void main(String[] args) throws Exception {
        int[] array = {3,2,4,1,5};
        
        System.out.println("original arrange: ");
        for (int num : array) {
            System.out.println(num + " ");
        }

        Arrays.sort(array);
        System.out.println("\nSorted number: ");
        for (int num : array){
            System.out.println(num + " ");
        }
        
    }
    
}
