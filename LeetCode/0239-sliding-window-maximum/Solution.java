class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]){//remeber
                dq.pollLast();
            }
            dq.offerLast(i);
        }
      
        int ind=0;
        for(int i=k;i<nums.length;i++){
            ans[ind++]=nums[dq.peekFirst()];
            if(!dq.isEmpty()&&dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        ans[ind++]=nums[dq.peekFirst()];
        return ans;
        
    }
}