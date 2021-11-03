package solution;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 */
public class T_006 {

    public String longestPalindrome(String s) {
        int[] lens = new int[s.length()];
        lens[0] = 1;
        for(int i=1; i<s.length(); i++){
            int left=(i-1-lens[i-1])>=0 ? i-1-lens[i-1]:0;
            if(lens[i-1]<i &&s.charAt(left) == s.charAt(i)){
                lens[i] = lens[i-1]+2;
            }else{
                for(;left<=i; left++){
                    if(isPalindorme(s, left, i)){
                        lens[i] = i-left+1;
                        break;
                    }
                }
            }
        }
        int max = 0, idx = 0;
        for(int i=0; i<lens.length;i++){
            if(lens[i] > max){
                max = lens[i];
                idx = i;
            }
        }
        return s.substring(idx-max+1, idx+1);

    }

    public boolean isPalindorme(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left++)==s.charAt(right--)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    
}
