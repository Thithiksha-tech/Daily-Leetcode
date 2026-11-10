class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long maxSum = 0;

        // Build the first window of size k
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }

        if (map.size() == k) {
            maxSum = sum;
        }

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            // Add incoming element
            int inVal = nums[i];
            map.put(inVal, map.getOrDefault(inVal, 0) + 1);
            sum += inVal;

            // Remove outgoing element
            int outVal = nums[i - k];
            map.put(outVal, map.get(outVal) - 1);
            sum -= outVal;

            if (map.get(outVal) == 0) {
                map.remove(outVal);
            }

            // Check if current window has all distinct elements
            if (map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
