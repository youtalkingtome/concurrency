package collectors.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber that)) return false;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String > numberMap = new HashMap<>();
        numberMap.put(new PhoneNumber((short) 732, (short) 639, (short) 7789), "vikas");
        System.out.print(numberMap.get(new PhoneNumber((short) 732, (short) 639, (short) 7789)));

    }
}
