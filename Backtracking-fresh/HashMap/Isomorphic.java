package HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class Isomorphic {
   public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length())return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> st = new HashSet<>();

        for(int  i = 0 ; i < s.length() ; i++){

            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }else {
                if(st.contains(t.charAt(i)))return false;

                map.put(s.charAt(i), t.charAt(i));
                st.add(t.charAt(i));
            }
        }
        return true ;
    }
}
