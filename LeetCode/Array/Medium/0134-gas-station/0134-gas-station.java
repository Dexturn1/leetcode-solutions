class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }


        if(totalCost > totalGas)
            return -1;
        
        int start = 0;
        int fule = 0;
        for(int i = 0; i<n; i++){

            fule += (gas[i] - cost[i]);

            if(fule < 0){
                start = i+1;
                fule = 0;
            }

        }
        return start;
        
    }
}