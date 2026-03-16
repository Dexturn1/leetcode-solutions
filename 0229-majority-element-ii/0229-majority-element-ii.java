class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ans= new ArrayList<>();
        Map <Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        int min = (n/3)+1;

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);

            if(map.get(num) == min){
                ans.add(num);
            }

            if(ans.size() == 2) break;

        }

        return ans;
        
    }
}