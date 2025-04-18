package collectors;

import java.util.HashMap;
import java.util.Map;

public class BadHashEqualsBoth {


    int id;

    public BadHashEqualsBoth(int i) {
    }

    @Override
    public String toString() {
        return "BadHash{id=" + id + "}";
    }// All seen as different

    public static void main(String[] args) {

        Map<BadHashEqualsBoth, String> map = new HashMap<>();

        map.put(new BadHashEqualsBoth(0), "0");
        map.put(new BadHashEqualsBoth(1), "1");
        map.put(new BadHashEqualsBoth(2), "2");
        map.put(new BadHashEqualsBoth(3), "3");
        map.put(new BadHashEqualsBoth(3), "4");
        map.put(new BadHashEqualsBoth(3), "5");

        System.out.println("Map Size"+ map.size());
        System.out.println("\nRetrieving values:");
        for (Map.Entry<BadHashEqualsBoth, String> entry : map.entrySet()) {
            System.out.println("Key"+ entry.getKey().toString());
            System.out.println("Value"+ entry.getValue());
        }


    }
}

