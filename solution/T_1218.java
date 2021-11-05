package solution;

import java.util.*;

/*
给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。

子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T_1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        for(Integer num : arr){
            int newLen = countMap.getOrDefault(num - difference, 0)+1;
            max = max < newLen ? newLen : max;
            countMap.put(num, newLen);
        }

        return max;
    }
}
