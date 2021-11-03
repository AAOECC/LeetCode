package solution;

import java.util.*;

public class T_084 {
   
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> preList = new ArrayList<>();
        for(int num : nums){
            if(countMap.containsKey(num)){
                countMap.replace(num, countMap.get(num)+1);
            }else{
                countMap.put(num, 1);
            }
        }
        putin(preList, countMap);
        return res;
    }

    public void putin(List<Integer> preList, HashMap<Integer, Integer> countMap){
        if(!countMap.isEmpty()){
            for(Integer n : countMap.keySet()){
                List<Integer> newList = new ArrayList<>();
                newList = preList;
                HashMap<Integer, Integer> newMap = (HashMap) countMap.clone();
                int count = countMap.get(n)-1;
                if(count==0){
                    newMap.remove(n);
                }else{
                    newMap.replace(n, count);
                }
                newList.add(n);
                putin(newList, newMap);
            }
        }else{
            res.add(preList);
        }
    }
}
