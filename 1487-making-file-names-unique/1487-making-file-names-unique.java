class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String curr = names[i];

            if (!map.containsKey(curr)) {
                ans[i] = curr;
                map.put(curr, 1);
            } else {
                int k = map.get(curr);

                while (map.containsKey(curr + "(" + k + ")")) {
                    k++;
                }

                String unique = curr + "(" + k + ")";
                ans[i] = unique;

                map.put(curr, k + 1);
                map.put(unique, 1);
            }
        }

        return ans;
    }
}