public class Solution8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("   -042"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-2147483648"));
    }

    public static int myAtoi(String s) {
        String trimmed = s.trim();
        if (trimmed.isEmpty())
            return 0;

        int sign = 1, i = 0;
        long result = 0;

        if (trimmed.charAt(0) == '-' || trimmed.charAt(0) == '+') {
            sign = trimmed.charAt(0) == '-' ? -1 : 1;
            i++;
        }

        while (i < trimmed.length() && Character.isDigit(trimmed.charAt(i))) {
            result = result * 10 + (trimmed.charAt(i) - '0');

            if (sign * result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * result);
    }
}
