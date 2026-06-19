package Arrays;

class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        
        int buy = prices[0] ; 
        int result = Integer.MIN_VALUE;

        for(int i = 1 ; i < prices.length ; i++){
            
            if(buy >= prices[i]){
                buy = prices[i];
                continue ; 
            }

            result = Math.max(result, prices[i]-buy);
            
        }

        if(result == Integer.MIN_VALUE){
            return 0;
        }
        return result;
    }
}