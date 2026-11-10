class Solution {
    static int l;
    static int h;
    
    public void reverseString(char[] s) {
        l=0;
        h=s.length-1;
        solve(s,l,h);  
    }
    public static void solve(char[] s,int l,int h){
        if(l>=h){
            return;
        }
        char temp=s[l];
        s[l]=s[h];
        s[h]=temp;
        l++;
        h--;
        solve(s,l,h);
    }
}