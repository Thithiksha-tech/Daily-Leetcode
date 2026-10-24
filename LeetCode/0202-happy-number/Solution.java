class Solution {

    public int sqdigits(int n) {
        int sum=0;
        while(n>0) {
            int t = n%10;
            sum+=(t*t);
            n/=10;
        }

        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = sqdigits(slow);
            fast = sqdigits(sqdigits(fast));
        }while(fast!=slow);

        return slow==1;
    }
}