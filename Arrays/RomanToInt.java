import java.util.HashMap;

public class RomanToInt {
   public int romanToInt(String s) {

       HashMap<Character, Integer> map = new HashMap<>();

       map.put('I', 1);
       map.put('V', 5); 
       map.put('X', 10);
       map.put('L', 50); 
       map.put('C', 100);
       map.put('D', 500); 
       map.put('M', 1000);

       int sum = 0 ; 
       int prev = 0 ;

       for(int i = 0 ; i < s.length() ; i++){

            if(map.get(s.charAt(i)) > prev && i!=0){
                sum-=prev;
                sum+=map.get(s.charAt(i)) - prev;
                continue;
            }
            prev = map.get(s.charAt(i));
            sum+=map.get(s.charAt(i));
       }
       return sum;
    }
}
