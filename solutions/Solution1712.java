package solutions;
public class Solution1712 {
    public static void main(String[] args) {

    }

    //Brute Force Approach with Prefix Sum Time Limit Exceeded
    public int waysToSplitBruteForcePrefix(int[] nums) {
        int mod = 1_000_000_007;
        int n = nums.length;
        int count = 0;

        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                long leftSum = prefix[i];
                long midSum = prefix[j] - prefix[i];
                long rightSum = prefix[n - 1] - prefix[j];

                if (leftSum <= midSum && midSum <= rightSum) {
                    count = (count + 1) % mod;
                }
            }
        }

        return count;
    }

    //Brute Force Approach Time Limit Exceeded
    public int waysToSplitBruteForce(int[] nums) {
        int mod = 1_000_000_007;
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {   
            for (int j = i + 1; j < n - 1; j++) { 
                int leftSum = 0;
                int midSum = 0;
                int rightSum = 0;

                for (int a = 0; a <= i; a++) {
                    leftSum += nums[a];
                }

                for (int a = i + 1; a <= j; a++) {
                    midSum += nums[a];
                }

                for (int a = j + 1; a < n; a++) {
                    rightSum += nums[a];
                }

                if (leftSum <= midSum && midSum <= rightSum) {
                    count = (count + 1) % mod;
                }
            }
        }

        return count;
    }

    //Optimized Approach with Prefix Sum and Binary Search
    public int waysToSplit(int[] nums) {
        int mod = 1_000_000_007;
        int n = nums.length;

        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long total = prefix[n - 1];
        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            long leftSum = prefix[i];

            if (leftSum * 3 > total) {
                break;
            }

            int first = lowerBound(prefix, i + 1, n - 2, 2 * leftSum);
            int last = upperBound(prefix, i + 1, n - 2, (total + leftSum) / 2);

            if (first <= last) {
                count += (last - first + 1);
                count %= mod;
            }
        }

        return (int) count;
    }

    private int lowerBound(long[] prefix, int left, int right, long target) {
        int ans = right + 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private int upperBound(long[] prefix, int left, int right, long target) {
        int ans = left - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }


}