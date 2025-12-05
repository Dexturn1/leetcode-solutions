class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0 ;
        int twenty = 0;

        for(int i = 0; i<bills.length; i++){

            if(bills[i] == 5){
                five++;
            }

            if(bills[i] == 10){
                if(five < 1){
                    return false;
                }
                else{
                    ten++;
                    five--;
                }
            }
            if(bills[i] == 20){
                if(five > 0 && ten > 0){
                    twenty++;
                    five--;
                    ten--;
                }
                else if(five >= 3){
                    twenty++;
                    five -= 3;
                }
                else{
                    return false;
                }
            }


        }


        return true;
        
    }
}