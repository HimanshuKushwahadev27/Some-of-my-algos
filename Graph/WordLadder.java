package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord); // mark as visited by removing from the set

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return level;
                }

                char[] chars = current.toCharArray();

                // Try changing every position to every other letter of the alphabet
                for (int pos = 0; pos < chars.length; pos++) {
                    char originalChar = chars[pos];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) {
                            continue;
                        }

                        chars[pos] = c;
                        String candidate = new String(chars);

                        if (wordSet.contains(candidate)) {
                            wordSet.remove(candidate); // mark visited immediately to avoid re-processing
                            queue.offer(candidate);
                        }
                    }

                    chars[pos] = originalChar; // restore before trying the next position
                }
            }

            level++;
        }

        return 0; 
    }
}
