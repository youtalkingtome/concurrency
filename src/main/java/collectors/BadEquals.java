package collectors;

import java.util.HashMap;
import java.util.Map;

public class BadEquals {

    int id;

    public BadEquals(int i) {
        this.id=i;
    }
    public int hashCode() { return 42; } // All hash to same bucket
    @Override
    public boolean equals(Object o) {
      return false;
    }
    @Override
    public String toString() {
        return "BadHash{id=" + id + "}";
    }// All seen as different

    public static void main(String[] args) {

        Map<BadEquals, String> map = new HashMap<>();

        map.put(new BadEquals(0), "0");
        map.put(new BadEquals(1), "1");
        map.put(new BadEquals(2), "2");
        map.put(new BadEquals(3), "3");
        map.put(new BadEquals(3), "4");
        map.put(new BadEquals(3), "5");

        System.out.println("Map Size"+ map.size());

        System.out.println(map.size());

        System.out.println("\nRetrieving values:");
        for (Map.Entry<BadEquals, String> entry : map.entrySet()) {
            System.out.println("Key"+ entry.getKey().toString() + "===="+"Value"+ entry.getValue());
        }

    }
}
