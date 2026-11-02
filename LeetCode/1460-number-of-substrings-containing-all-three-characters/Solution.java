class Solution {
    public int numberOfSubstrings(String s) {
        int max=0;
        int r=0;
        int l=0;
        //for every r they are many strtingp point as l
        int[] freq=new int[26];
        while(r<s.length()){
            freq[s.charAt(r)-'a']++;
            while(freq[0]>0&&freq[1]>0&&freq[2]>0){
                max+=(s.length()-r);
                freq[s.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return max;
    }
}