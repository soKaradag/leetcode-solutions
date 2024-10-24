import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    // Verimsiz bir çözüm. Algoritma zaman karmaşıklığı O(n^3)
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subStr = s.substring(i, j + 1);
                if (!hasRepeatingCharacters(subStr)) {
                    maxLength = Math.max(maxLength, subStr.length());
                }
            }
        }
        return maxLength;
    }

    public static boolean hasRepeatingCharacters(String s) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                return true;
            }
            charSet.add(c);
        }
        return false;
    }

    // Kayan pencere yöntemi
    // O(n) zaman karmaşıklığına sahip daha verimli algoritma.
    public static int lengthOfLongestSubstringSecond(String s) {
        int maxLength = 0;
        int start = 0;
        Set<Character> charSet = new HashSet<>();

        for (int end = 0; end < s.length(); end++) {
            while (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start));
                start++;
            }
            charSet.add(s.charAt(end));
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}