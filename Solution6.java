public class Solution6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder converted = new StringBuilder();
        int step = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += step) {
                converted.append(s.charAt(j));

                int diagIndex = j + step - 2 * i;
                if (i > 0 && i < numRows - 1 && diagIndex < s.length()) {
                    converted.append(s.charAt(diagIndex));
                }
            }
        }
        return converted.toString();
    }
}
