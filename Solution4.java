import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));

    }

    // Algoritma zaman karmaşıklığıA O(n log n)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int[] mergedArray = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);

        Arrays.sort(mergedArray);

        if (mergedArray.length % 2 != 0) {
            median = mergedArray[((mergedArray.length - 1) / 2)];
        } else {
            median = (mergedArray[mergedArray.length / 2 - 1] + mergedArray[mergedArray.length / 2]) / 2.0;
        }

        return median;
    }

    // Algoritma zaman karmaşıklığı O(log(min(n, m)))
    public static double findMedianSortedArraysSecond(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}