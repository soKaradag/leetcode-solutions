public class Solution7 {
    public static void main(String[] args) {
        System.out.println(reverse(12));
        System.out.println(reverse(-123));
        System.out.println(reverse(1534236469));
    }

    // Low memory usage but high runtime
    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));

        if (sb.charAt(0) == '-') {
            sb = sb.deleteCharAt(0).reverse().insert(0, '-');
        } else {
            sb.reverse();
        }

        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // Low runtime but high memory usage
    public static int reverseSecond(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

}
