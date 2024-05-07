package collectors.algorithms;

public class StringToIntegerWithoutLibrary {
    public static int stringToInteger(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int ans = 0, i = 0;
        boolean neg = s.charAt(0) == '-';
        boolean pos = s.charAt(0) == '+';

        if (neg || pos) {
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return neg ? -ans : ans;
    }



    public static void main(String[] args) {
        String str = "-042";
        System.out.println("String to integer: " + stringToInteger(str));

        String negativeStr = "337c0d3";
        System.out.println("String to integer (negative): " + stringToInteger(negativeStr));

        String invalidStr = "1337c0d3";
        try {
            System.out.println("String to integer (invalid): " + stringToInteger(invalidStr));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid string format: " + invalidStr);
        }
    }
}
