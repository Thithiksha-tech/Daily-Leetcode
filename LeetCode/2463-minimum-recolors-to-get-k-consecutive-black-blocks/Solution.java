class Solution {
    public int minimumRecolors(String s, int k) {
        int l=0;
        int r=0;
        int len=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='W'){
                len++;
            }
        }
        min=Math.min(len,min);
        for(int i=k;i<s.length();i++){
            if(s.charAt(i)=='W'){
                len++;
            }
            if(s.charAt(i-k)=='W'){
                len--;
            }
            min=Math.min(min,len);
        }
        return min;
        

    }
}