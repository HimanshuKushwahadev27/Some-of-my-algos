import java.util.ArrayList;
import java.util.List;

public class Justify {
   public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLength = words[i].length();
            int lastIndex = i + 1;

            // Greedily pack as many words as fit on this line.
            // +1 accounts for the single space needed before each additional word.
            while (lastIndex < words.length &&
                   lineLength + 1 + words[lastIndex].length() <= maxWidth) {
                lineLength += 1 + words[lastIndex].length();
                lastIndex++;
            }

            int wordCount = lastIndex - i;
            StringBuilder line = new StringBuilder();

            boolean isLastLine = lastIndex == words.length;

            if (isLastLine || wordCount == 1) {
                // Left-justify: single space between words, pad remaining on the right
                for (int j = i; j < lastIndex; j++) {
                    line.append(words[j]);
                    if (j < lastIndex - 1) {
                        line.append(' ');
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(' ');
                }
            }else {
                // Fully justify: distribute spaces evenly, extra spaces go to leftmost gaps
                int totalSpaces = maxWidth - (lineLength - (wordCount - 1)); 
                // totalSpaces = maxWidth - sum of word lengths
                int gaps = wordCount - 1;
                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int j = i; j < lastIndex; j++) {
                    line.append(words[j]);
                    if (j < lastIndex - 1) {
                        int spacesToAdd = spacesPerGap + (j - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToAdd; s++) {
                            line.append(' ');
                        }
                    }
                }
            }

            result.add(line.toString());
            i = lastIndex;
        }

        return result;

    }
}
