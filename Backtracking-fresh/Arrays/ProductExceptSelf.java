public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int [] prefix = new int[nums.length];
        int  [] suffix = new int[nums.length];

        suffix[nums.length-1]=1;
        prefix[0]=1;

        for(int i = 1 ; i < nums.length ; i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }

        for(int i = nums.length-2 ; i>=0 ; i--){
            suffix[i] = suffix[i+1]*nums[i+1];
            nums[i+1] = suffix[i+1]*prefix[i+1];
        }

        nums[0] = suffix[0]*prefix[0];

        return nums;


    }
}
