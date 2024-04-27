package collectors.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolveAgain {

    public static void main(String[] args) {

        int[] array = {2,7,11,15,8,1};
        int target = 12;
        boolean found =  false;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=1; i< array.length; i++)
        {
            int complement = target-array[i];
            if(map.containsKey(complement))
            {
                System.out.println("Pair Sum Found" + complement +"," +array[i]);
                found=true;

            }
            map.put(i, array[i]);
        }
        if(!found)
        {
            System.out.print("No Pair Found");
        }
    }

}
