package collectors.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static boolean checkAnagramCount(String word1, String word2) {
        // Remove any white space and convert strings to lowercase
        word1= word1.replaceAll("\\s", "").toLowerCase();
        word2 = word2.replaceAll("\\s", "").toLowerCase();

        // Check if lengths are equal
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> charCountsMap = new HashMap<>();

        // Count characters from the first word
        for (char c : word1.toCharArray()) {
            charCountsMap.put(c, charCountsMap.getOrDefault(c, 0) + 1);
        }

        // Loop over word 2 and get the count of the same character.
        for (char c : word2.toCharArray()) {
            int count = charCountsMap.getOrDefault(c, 0);
            if (count == 0) {
                return false; // The words are not anagram
            }
            charCountsMap.put(c, count - 1);
        }

        charCountsMap.forEach((K,V)->{                 // mapofmaps entries
            // inner Hashmap enteries
                System.out.println(K+" "+V);       // print key and value of inner Hashmap

        });
        return true;
    }
    public static boolean checkAnagram(String word1, String word2) {
        //removing spaces and converting to lower case

        word1 = word1.replaceAll("\\s", "").toLowerCase();
        word2 = word2.replaceAll("\\s", "").toLowerCase();

        // Check if lengths are equal
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] characterCount = new int[26]; // Assuming English letters

        // we need to create the array of characters with the count of each letter
        // occurance and that is achieved using
        // Count characters from the first string
        for (int i = 0; i < word1.length(); i++) {
            characterCount[word1.charAt(i) - 'a']++;
        }

        // Subtract counts using the second string
        for (int i = 0; i < word2.length(); i++) {
            if (--characterCount[word2.charAt(i) - 'a'] < 0) {

                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkAnagram("listen", "silent"));


    }
}
