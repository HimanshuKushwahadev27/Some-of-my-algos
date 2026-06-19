package Arrays;

class BuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        
        int result = 0 ; 

        int buy = prices[0];


        for(int i = 1 ; i < prices.length ; i++){
            
            if(i-1 == 0 && prices[i] < buy){
                buy = prices[i];
                continue;
            }

            if(prices[i] < prices[i-1]){
                result += prices[i-1]-buy ;
                buy = prices[i];
            }

            if(i==prices.length-1 && buy<prices[i]){
                result += prices[i]-buy ;
            }

        }
        return result;
    }
}