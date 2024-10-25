public class Solution5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

    // Zaman karmaşıklığı O(n^3)
    public static String longestPalindrome(String s) {
        String checkedWord;
        String polindromString = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                checkedWord = s.substring(i, j);
                if (isPolindrom(checkedWord) && checkedWord.length() > polindromString.length()) {
                    polindromString = checkedWord;
                }

            }
        }

        return polindromString;
    }

    public static boolean isPolindrom(String s) {
        StringBuilder flip = new StringBuilder(s);
        return s.equals(flip.reverse().toString());
    }

    // Zaman karmaşıklığı O(n^2) uzay karmaşıklığı O(1)
    public static String longestPalindromeSecond(String s) {
        if (s.length() < 1)
            return "";
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = expandAroundCenter(s, i, i);
            String evenPalindrome = expandAroundCenter(s, i, i + 1);

            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }

        return longest;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
