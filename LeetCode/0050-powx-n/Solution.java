class Solution {
    public static double recur(double x,long n){
        //what is the smallest porblem
        if(n==0){
            return 1;
        }
        //how can i make the porblem smaller
        double half=recur(x,n/2);
        //how do i reach the final answer
        if(n%2==0){
            return half*half;
        }
        return x*half*half;
        
            
    }
    public double myPow(double x, int n) {
        
        double a=recur(x,Math.abs((long)n));
        if(n>0){
            return a;
        }
        return 1/a;
        
    }
}