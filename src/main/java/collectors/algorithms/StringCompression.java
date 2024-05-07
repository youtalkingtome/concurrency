package collectors.algorithms;

public class StringCompression {

        public static String compress(String input) {
            if (input == null || input.length() == 0) {
                return input;
            }

            StringBuilder compressed = new StringBuilder();
            int count = 1;

            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) == input.charAt(i - 1)) {
                    count++;
                } else {
                    compressed.append(input.charAt(i - 1));
                    compressed.append(count);
                    count = 1;  // reset count for the new character
                }
            }

            // Append the last set of character and count
            compressed.append(input.charAt(input.length() - 1));
            compressed.append(count);

            // Return the original string if compression does not reduce string size
            return compressed.length() < input.length() ? compressed.toString() : input;
        }

        public static void main(String[] args) {
            String s1 = "aabcccccaaa";
            System.out.println(compress(s1));  // Output: "a2b1c5a3"

            String s2 = "abcd";
            System.out.println(compress(s2));  // Output: "abcd" (since compressed string would be longer)
        }
    }

