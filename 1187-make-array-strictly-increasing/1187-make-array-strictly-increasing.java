import java.util.*;

class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {

        Arrays.sort(arr2);

        // Remove duplicates
        int m = 1;
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] != arr2[m - 1]) {
                arr2[m++] = arr2[i];
            }
        }

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(-1, 0);

        for (int num : arr1) {

            Map<Integer, Integer> next = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {

                int prev = entry.getKey();
                int cost = entry.getValue();

                // Keep current number
                if (num > prev) {
                    next.put(num,
                            Math.min(next.getOrDefault(num, Integer.MAX_VALUE), cost));
                }

                // Replace current number
                int idx = upperBound(arr2, m, prev);

                if (idx < m) {
                    int replace = arr2[idx];
                    next.put(replace,
                            Math.min(next.getOrDefault(replace, Integer.MAX_VALUE), cost + 1));
                }
            }

            dp = next;

            if (dp.isEmpty())
                return -1;
        }

        int ans = Integer.MAX_VALUE;

        for (int val : dp.values())
            ans = Math.min(ans, val);

        return ans;
    }

    private int upperBound(int[] arr, int len, int target) {

        int l = 0, r = len;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}