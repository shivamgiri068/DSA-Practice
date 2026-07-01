class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        // Add all numbers to set
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        for(int i=0; i<=n; i++){
            if(!set.contains(i))
            return i;

        }
        return -1;
        
    }
}