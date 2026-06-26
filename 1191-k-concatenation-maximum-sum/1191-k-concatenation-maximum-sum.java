class Solution {

    private static final int MOD = 1000000007;

    public int kConcatenationMaxSum(int[] arr, int k) {

        long totalSum = 0;
        for (int num : arr)
            totalSum += num;

        if (k == 1)
            return (int) (kadane(arr) % MOD);

        int n = arr.length;
        int[] twice = new int[2 * n];

        for (int i = 0; i < n; i++) {
            twice[i] = arr[i];
            twice[i + n] = arr[i];
        }

        long bestTwo = kadane(twice);

        if (totalSum > 0)
            bestTwo += (long) (k - 2) * totalSum;

        return (int) (bestTwo % MOD);
    }

    private long kadane(int[] nums) {
        long maxSum = 0;
        long current = 0;

        for (int num : nums) {
            current = Math.max(0, current + num);
            maxSum = Math.max(maxSum, current);
        }

        return maxSum;
    }
}