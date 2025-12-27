class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();

        int max = -1;

        for(int i: arr){
            max = Math.max(i, max);
        }

        for(int i = 1; i<= max; i++){
            list.add(i);
        }

        for(int i: arr){
                list.remove(Integer.valueOf(i)); 
        }

        if(list.size() >= k){
            return list.get(k-1);
        }
        else{
            while(list.size() <k){
                list.add(++max);
            }
        }
        return list.get(k-1);
        
    }
}