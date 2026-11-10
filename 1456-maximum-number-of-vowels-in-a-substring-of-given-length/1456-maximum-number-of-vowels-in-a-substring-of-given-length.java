class Solution {
    public static boolean isvowel(char st){
        if(st=='a'||st=='e'||st=='i'||st=='o'||st=='u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int vc=0;
        int max=-1;
        for(int i=0;i<k;i++){
            if(isvowel(s.charAt(i))){
                vc++;
            }
        }
        max=Math.max(max,vc);
        for(int i=k;i<s.length();i++){
            if(isvowel(s.charAt(i))){
                vc++;
            }
            if(isvowel(s.charAt(i-k))){
                vc--;
            }
            max=Math.max(vc,max);
        }
        return max;

    }
}