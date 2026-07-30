package HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
   public boolean wordPattern(String pattern, String s) {
        
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> st = new HashSet<>();

        int i = 0 ;
        int j = 0 ;
        while(i < s.length() && j < pattern.length()){

            while (i < s.length() && s.charAt(i) == ' ') i++;
            if (i == s.length()) break;

            StringBuilder sb = new StringBuilder();
            
            while (i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }


            if(map.containsKey(pattern.charAt(j))){
                if(!map.get(pattern.charAt(j)).equals(sb.toString()))return false;
            }else{

                if(st.contains(sb.toString()))return false;

                map.put(pattern.charAt(j), sb.toString());
                st.add(sb.toString());
            }

            j++;
        }

         return i == s.length() && j == pattern.length();
    }
}
