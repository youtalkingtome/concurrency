package collectors.algorithms;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = romanValues.get(s.charAt(i));

            if (currValue < prevValue) {
                result -= currValue;
            } else {
                result += currValue;
            }

            prevValue = currValue;
        }

        return result;
    }

    public static void main(String[] args) {
        RomanToInteger converter = new RomanToInteger();

        // Example usage:
        String romanNumeral1 = "III";
        String romanNumeral2 = "IV";
        String romanNumeral3 = "IX";
        String romanNumeral4 = "LVIII";
        String romanNumeral5 = "MCMXCIV";

        //System.out.println(romanNumeral1 + " -> " + converter.romanToInt(romanNumeral1));
        System.out.println(romanNumeral2 + " -> " + converter.romanToInt(romanNumeral2));
        //System.out.println(romanNumeral3 + " -> " + converter.romanToInt(romanNumeral3));
        //System.out.println(romanNumeral4 + " -> " + converter.romanToInt(romanNumeral4));
        //System.out.println(romanNumeral5 + " -> " + converter.romanToInt(romanNumeral5));
    }
}
