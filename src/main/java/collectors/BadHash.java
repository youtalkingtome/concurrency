package collectors;


import java.util.HashMap;
import java.util.Map;

public class BadHash {
    int id;

    public BadHash(int i) {
        this.id=i;
    }

    public int hashCode() { return 42; } // All hash to same bucket
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadHash other = (BadHash) o;
        return this.id == other.id;
    }
    @Override
    public String toString() {
        return "BadHash{id=" + id + "}";
    }// All seen as different

    public static void main(String[] args) {

        Map<BadHash, String> map = new HashMap<>();
        map.put(new BadHash(0), "0");
        map.put(new BadHash(1), "1");
        map.put(new BadHash(2), "2");
        map.put(new BadHash(3), "3");
        map.put(new BadHash(11), "99");


        System.out.println("Map Size"+ map.size());
        System.out.println("\nRetrieving values:");
        for (Map.Entry<BadHash, String> entry : map.entrySet()) {
            System.out.println("Key"+ entry.getKey().toString() + "===="+"Value"+ entry.getValue());
        }


    }
}
