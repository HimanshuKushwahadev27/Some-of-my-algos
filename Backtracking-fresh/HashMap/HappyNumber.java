package HashMap;

import java.util.HashSet;

public class HappyNumber {
   public boolean isHappy(int n) {
        
        if(n == 1 || n == 10)return true;
        
        HashSet<Integer> set = new HashSet<>();

        while(n != 1){

            if(set.contains(n))return false;
            set.add(n);

            int sum = 0 ;

            while(n > 0){
                int digit = n % 10 ;
                sum += digit*digit;
                n/=10 ;
            }

            n = sum ;
        }

        return true;


    }
}
