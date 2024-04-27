package collectors.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static void main(String[] args) {
        int[] array = {2,7,11,15,8,1};

        if (array == null || array.length < 3) {
            System.out.println("No pairs found or array is too short!");
            return;
        }

        int targetSum=12;
        boolean found =  false;
        Map<Integer, Integer> map = new HashMap<>();
        for( int j=1 ; j< array.length; j++)
        {
            int complement =  targetSum - array[j];
            if (map.containsKey(complement))
            {
                System.out.println("Pair Sum Found" + complement +"," +array[j]);
                found =  true;
            }
            map.put(j, array[j]);
            if(!found)
            {
                System.out.print("No Pair Found");
            }

        }
    }
}
