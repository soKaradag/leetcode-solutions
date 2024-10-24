import java.util.HashMap;

public class Solution13 {
    public static void main(String[] args) {
        String roman = "XIV";
        int result = romanToInt(roman);
        System.out.println("Roma rakamı " + roman + " sayıya çevirildi: " + result);
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        int result = 0;
        int prevValue = 0;

        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));

            if (prevValue > currentValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
}
