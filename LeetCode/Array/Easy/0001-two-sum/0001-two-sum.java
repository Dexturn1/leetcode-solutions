class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans [] = new int[2];

        for(int i = 0; i<n; i++){
            int num = nums[i];
            int lookingFor = target - num;

            if(map.containsKey(lookingFor)){
                ans[0] = i;
                ans[1] = map.get(lookingFor);
                Arrays.sort(ans);
                return ans;
            }

            map.put(num, i);
        }
        return ans;

    }
}