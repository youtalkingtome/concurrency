package collectors.algorithms;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "dogchase", "dogman"};

        String prefix=strs1[0];//flower
        for (int i=1; i<strs1.length ; i++)
        {
            while(strs1[i].indexOf(prefix)!=0)
            {
                prefix=prefix.substring(0,prefix.length()-1);

            }
        }
        System.out.println(prefix);

        String prefix1=strs2[0];//flower
        for (int i=1; i<strs2.length ; i++)
        {
            while(strs2[i].indexOf(prefix1)!=0)
            {
                prefix1=prefix1.substring(0,prefix1.length()-1);

            }
        }
        System.out.println(prefix1);

    }

}

