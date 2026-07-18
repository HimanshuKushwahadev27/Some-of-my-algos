public class SmallestNumberNonZero {
      public int find(int[] arr) {
        // code here
        double value = 0 ;
        double maxVal = 0 ;
        double denom = 2 ;
        
        for(int i = 0 ; i < arr.length ; i++){
            value += arr[i]/denom ;
            
            maxVal = Math.max(maxVal, value);
            
            denom *= 2 ;
        }
        
        long ans = (long) Math.ceil(maxVal);
        ans = Math.max(ans, 1);
        
        return (int)ans;
    }
}
