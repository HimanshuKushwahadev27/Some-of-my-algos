public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            
            for (int num : nums) {
                bitSum += (num >> i) & 1; // count how many numbers have a 1 at bit position i
            }
            
            if (bitSum % 3 != 0) {
                result |= (1 << i); // this bit belongs to the single number
            }
        }
        
        return result;
    }
}
