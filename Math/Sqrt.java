package Math;

public class Sqrt {
      public int mySqrt(int x) {
        if (x == 0) return 0;
        
        long left = 1, right = x;
        long result = 0;

        while(left <= right){
            long mid = left + (right - left)/2 ;

            long sqr = mid * mid;

            if(sqr == x){
                return (int)mid;
            }else if(sqr <x){
                result = mid ;
                left = mid + 1;
            }else{
                right = mid - 1 ;
            }
        }

        return (int)result ;
    }
}
