public class ReverseBits {
     public int reverseBits(int n) {
        
        String binary = Integer.toBinaryString(n);

        StringBuilder padded = new StringBuilder();

        for (int i = 0; i < 32 - binary.length(); i++) {
            padded.append('0');
        }
        padded.append(binary);

        String reversed = padded.reverse().toString();
        
        long result = Long.parseLong(reversed, 2);
        
        return (int) result;

    }
}