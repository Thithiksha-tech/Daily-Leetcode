class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0){
            return new int[0];
        }
        Deque<Integer> dp=new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!dp.isEmpty()&&nums[dp.peekLast()]<nums[i]){
                dp.pollLast();
            }
        
                dp.offerLast(i);
            
        }
        int ind=0;
        int[] ans=new int[nums.length-k+1];
        for(int i=k;i<nums.length;i++){
            ans[ind++]=nums[dp.peekFirst()];
            //valid window
            if(!dp.isEmpty()&&dp.peekFirst()<=i-k){
                dp.pollFirst();
            }
            //checking for useful elements if small elememts exist pop
            while(!dp.isEmpty()&&nums[dp.peekLast()]<nums[i]){
                dp.pollLast();
            }
            
            dp.offerLast(i);
        }
        ans[ind++]=nums[dp.peekFirst()];
        return ans;
        
        
    }
}