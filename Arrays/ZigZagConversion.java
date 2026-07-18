public class ZigZagConversion {
   public String convert(String s, int numRows) {
        if(numRows==1)return s;

        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i = 0 ; i < numRows ; i++)
            rows[i] = new StringBuilder();

        int currentRow = 0;
        int currentDirection = -1;

        for(int i = 0 ; i < s.length() ; i++){
            rows[currentRow].append(s.charAt(i));

            if(currentRow==0)currentDirection = 1;
            if (currentRow == numRows - 1) currentDirection = -1;

            currentRow += currentDirection;
        }
        

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows)
            result.append(row);

        return result.toString();
    }
}
