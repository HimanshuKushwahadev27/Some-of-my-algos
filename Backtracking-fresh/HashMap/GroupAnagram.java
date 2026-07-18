package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
   public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> al = new ArrayList<>();
        HashMap<String, List<String>> map  = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){

            char [] helper = strs[i].toCharArray();
            Arrays.sort(helper);
            String sorted = new String(helper);

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(strs[i]);
        }

        for(List<String> list : map.values()){
            al.add(list);
        }

        return al ;
    }
}
