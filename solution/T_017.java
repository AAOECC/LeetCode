package solution;

import java.util.*;

public class T_017 {
    private String[] numToStr = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        int len = digits.length();
        for(int i=0; i<len; i++){
            char c = digits.charAt(i);
            int num = (int)(c-'0');
            String str = numToStr[num];
            addStr(res, str);
        }
        return res;
    }

    public void addStr(List<String> aList, String str){
        int len = aList.size();
        if(len == 0){
            for(int i=0; i<str.length(); i++){
                aList.add(str.substring(i, i+1).toString());
            }
        }else{
            for(int i=0; i<len; i++){
                String pre = aList.get(i);
                for(int j=0; j<str.length(); j++){
                    aList.add(pre+str.substring(j, j+1));
                }
            }
        }
        for(int i=0; i<len; i++){
            aList.remove(0);
        }
    }    
    
}
