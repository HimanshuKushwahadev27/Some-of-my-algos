package Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Mutations {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        
        char[] genes = {'A', 'C', 'G', 'T'};
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(startGene);
        visited.add(startGene);
        
        int mutations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                if (curr.equals(endGene)) {
                    return mutations;
                }
                
                char[] currArr = curr.toCharArray();
                
                for (int j = 0; j < currArr.length; j++) {
                    char original = currArr[j];
                    
                    for (char g : genes) {
                        if (g == original) continue;
                        
                        currArr[j] = g;
                        String mutated = new String(currArr);
                        
                        if (bankSet.contains(mutated) && !visited.contains(mutated)) {
                            visited.add(mutated);
                            queue.offer(mutated);
                        }
                    }
                    
                    currArr[j] = original; // restore
                }
            }
            
            mutations++;
        }
        
        return -1;
    }
}
