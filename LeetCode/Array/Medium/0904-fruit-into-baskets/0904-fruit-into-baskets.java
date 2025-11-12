class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxlen = 0;
        Map<Integer,Integer> mpp = new HashMap<>();

        for(int right = 0; right<fruits.length; right++){

            mpp.put(fruits[right], mpp.getOrDefault(fruits[right],0)+1);

            if(mpp.size() > 2){

                mpp.put(fruits[left],mpp.get(fruits[left])-1);
                if(mpp.get(fruits[left]) == 0){
                    mpp.remove(fruits[left]);
                }
                left++;
            }

            maxlen = Math.max(maxlen, right - left +1 );
        }

        return maxlen;
    }
}