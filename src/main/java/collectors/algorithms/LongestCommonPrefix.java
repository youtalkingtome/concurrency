package collectors.algorithms;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};

        String prefix=strs1[0];//flower
        for (int i=1; i<strs1.length ; i++)
        {
            while(strs1[i].indexOf(prefix)!=0)
            {
                prefix=prefix.substring(0,prefix.length()-1);

            }
        }
        System.out.println(prefix);

    }

}

