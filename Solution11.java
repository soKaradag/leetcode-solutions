public class Solution11 {
    public static void main(String[] args) {
        int[] heights = { 1, 1 };
        System.out.println(maxAreaCalculater2(heights));
    }

    // Zaman karmaşıklığı O(n^2)
    public static int maxAreaCalculater(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {

                if ((j - i) * Math.min(heights[i], heights[j]) > maxArea) {
                    maxArea = (j - i) * Math.min(heights[i], heights[j]);
                }
            }
        }
        return maxArea;
    }

    // Zaman karmaşıklığı O(n)
    public static int maxAreaCalculater2(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
