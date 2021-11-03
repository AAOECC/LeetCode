package solution;

import java.util.*;

public class T_015 {
    //关联集合
    private Map<Integer, List<Integer>> relatedMap = new HashMap<>();

    public List<List<Integer>> threeSum(int[] sum){
        List<List<Integer>> res = new ArrayList<>();
        //初始化 计数集合 和 关联集合
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for(int i=0; i<sum.length; i++){
            if(numMap.containsKey(sum[i])){
                numMap.replace(sum[i], numMap.get(sum[i])+1);
            }else{
                numMap.put(sum[i], 1);
            }
            if(!relatedMap.containsKey(sum[i])){
                List<Integer> putin = new ArrayList<>();
                relatedMap.put(sum[i], putin);
            }
        }
        Iterator<Integer> numMapiIterator = numMap.keySet().iterator();
        while(numMapiIterator.hasNext()){
            Integer num = numMapiIterator.next();
            HashMap<Integer, Integer> nowHashMap =(HashMap<Integer, Integer>)numMap.clone();
            //通过关联map 进行去重
            Iterator<Integer> it = nowHashMap.keySet().iterator();
            List<Integer> repeList = relatedMap.get(num);
            for (Integer repe : repeList) {
                changeMap(nowHashMap, repe, -1, nowHashMap.keySet().iterator());
            }
            changeMap(nowHashMap, num, -1, nowHashMap.keySet().iterator());; //减去自身

            
            while(it.hasNext()){
                Integer two = it.next();
                changeMap(nowHashMap, two, -1, nowHashMap.keySet().iterator());//先减去第二个数
                int needVal = 0-num-two;
                if(nowHashMap.containsKey(needVal)){
                    //满足条件
                    List<Integer> zeroSumList = new ArrayList<>();
                    zeroSumList.add(num);
                    zeroSumList.add(two);
                    zeroSumList.add(needVal);
                    changeMap(nowHashMap, needVal, -1, nowHashMap.keySet().iterator());
                    addRelational(zeroSumList);
                    res.add(zeroSumList);
                }else{
                    changeMap(nowHashMap, two, 1, nowHashMap.keySet().iterator()); //先前减去的数加回来
                }
            }
        }

        return res;
    }

    //添加已存在结果集中数字的关联
    public void addRelational(List<Integer> zeroSumList){
        for(int i=0; i<zeroSumList.size(); i++){
            int keynum = zeroSumList.get(i);
            for(int j=0; j<zeroSumList.size(); j++){
                if(i != j){
                    relatedMap.get(keynum).add(zeroSumList.get(j));
                }
            }
        }
    }

    /**
     * 更改map中的数据
     * @param changedMap
     * @param key
     * @param val
     */
    public void changeMap(Map<Integer, Integer> changedMap,Integer key, int val, Iterator<Integer> it) {
        
        if(!changedMap.containsKey(key)){
            changedMap.put(key, val);
        }else{
            int num = changedMap.get(key)+val;
            changedMap.replace(key, num);
        }
    }

    public boolean excited(Map<Integer, Integer> map, Integer key){
        
    }

    
}
