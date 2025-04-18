package collectors;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NoEquals {
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    int id;

    public NoEquals(int i) {
        this.id=i;
    }
    @Override
    public String toString() {
        return "BadHash{id=" + id + "}";
    }// All seen as different

    public static void main(String[] args) {

        Map<NoEquals, String> map = new HashMap<>();

        map.put(new NoEquals(0), "0");
        map.put(new NoEquals(1), "1");
        map.put(new NoEquals(2), "2");
        map.put(new NoEquals(3), "3");
        map.put(new NoEquals(3), "4");
        map.put(new NoEquals(3), "5");

        System.out.println("Map Size"+ map.size());

        System.out.println("Map Size"+ map.size());
        System.out.println("\nRetrieving values:");
        System.out.println("Map Size"+ map.size());
        System.out.println("\nRetrieving values:");
        for (Map.Entry<NoEquals, String> entry : map.entrySet()) {
            System.out.println("Key"+ entry.getKey().toString() + "===="+"Value"+ entry.getValue());
        }

    }
}
