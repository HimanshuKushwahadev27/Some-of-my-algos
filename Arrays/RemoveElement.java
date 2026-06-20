
class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int[] helper = new int[nums.length];

        int j = 0 , k = 0 ;

        for (int i = 0; i < nums.length; i++) {
            
            if(nums[i] != val){
                helper[j] = nums[i];
                j++;
            }
        }

        while(k < j){
            nums[k] = helper[k];
            k++;
        }

        return j;

    }
}