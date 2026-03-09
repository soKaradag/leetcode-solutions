package algorithms;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9, 11};
        int target = 7;

        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                break;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}