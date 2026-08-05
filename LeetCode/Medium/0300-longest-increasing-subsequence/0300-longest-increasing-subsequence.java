class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> lis = new ArrayList<>();

        lis.add(nums[0]);


        for(int i=1; i<nums.length; i++){

            if(nums[i] > lis.get(lis.size()-1))
                lis.add(nums[i]);

            else{
                int indx = lowerBound(lis, nums[i]);
                lis.set(indx, nums[i]);
            }
        }
        return lis.size();
    }

    public int lowerBound(List<Integer> arr, int target){
        int low = 0;
        int high = arr.size()-1;
        int ans = arr.size();

        while(low<= high){
            int mid = low+(high - low)/2;

            if(arr.get(mid) >= target){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

}