class Solution {
    public int maximumSum(int[] arr) {
        int keep = arr[0];
        int delete = 0;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int prevKeep = keep;

            keep = Math.max(arr[i], keep + arr[i]);
            delete = Math.max(delete + arr[i], prevKeep);

            ans = Math.max(ans, Math.max(keep, delete));
        }

        return ans;
    }
}