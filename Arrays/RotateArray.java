package Arrays;

class RotateArray {
    public void rotate(int[] nums, int k) {
        
        int length = nums.length;

        k = k%length;

        if(length == 1 || k==0 ){
            return;
        }

        int i = 0 , j = length-1;

        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        
        j = k-1;
        i = 0;

        //first k elements
        while(i < j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j--;
            i++;
        }

        i = k;
        j = length-1;
    // remaining ones
        while(i < j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j--;
            i++;
        }



    }
}