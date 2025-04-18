package collectors;

import java.util.HashMap;
import java.util.Map;

public class EqualsAndHashCode {

    int id;

    public EqualsAndHashCode(int i) {
        this.id=i;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    public static void main(String[] args) {

        EqualsAndHashCode key = new EqualsAndHashCode(0);
        Map<EqualsAndHashCode, String> map = new HashMap<>();
        map.put(key, "0");
        map.put(key, "1");
        map.put(key, "99");



        System.out.println("Map Size"+ map.size());
        System.out.println("\nRetrieving values:");
        for (Map.Entry<EqualsAndHashCode, String> entry : map.entrySet()) {
            System.out.println("Key"+ entry.getKey().toString() + "===="+"Value"+ entry.getValue());
        }


    }
}
