package collectors;

import java.util.HashMap;
import java.util.Map;

public class NoHashCode {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoHashCode that)) return false;
        return id == that.id;
    }
    int id;

    public NoHashCode(int i) {
        this.id=i;
    }
    @Override
    public String toString() {
        return "BadHash{id=" + id + "}";
    }// All seen as different

    public static void main(String[] args) {

         NoHashCode n1= new NoHashCode(3);
        NoHashCode n2= new NoHashCode(3);
        Map<NoHashCode, String> map = new HashMap<>();

        map.put(new NoHashCode(0), "0");
        map.put(new NoHashCode(1), "1");
        map.put(new NoHashCode(2), "2");
        map.put(new NoHashCode(3), "3");
        map.put(new NoHashCode(3), "4");
        map.put(new NoHashCode(3), "3");
        map.put(n1, "3");

        System.out.println("N1 Value"+map.get(n2));

        System.out.println("Map Size"+ map.size());

        System.out.println("Map Size"+ map.size());
        System.out.println("\nRetrieving values:");
        System.out.println("\nRetrieving values:");
        for (Map.Entry<NoHashCode, String> entry : map.entrySet()) {
            System.out.println("Key"+ entry.getKey().toString() + "===="+"Value"+ entry.getValue());
        }
    }
}
