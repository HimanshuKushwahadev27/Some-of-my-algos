public class TrappingRainWater {
   public int trap(int[] height) {
     
        int n = height.length ; 
        if(n==0)return 0;

        int [] leftMax = new int[n];
        int [] rightMax = new int[n];

        //we need trueMax so far on the left and right
        //not the nearest greater to left and right ;
        
        leftMax[0] = height[0];
        for(int i = 1 ; i < n  ; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n-1];
        for(int i = n-2 ; i >=0 ; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int water = 0 ; 

        for(int i = 0 ; i < n ; i++){
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water ;


    }
}
