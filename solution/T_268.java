package solution;


/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class T_268 {
    public int missingNumber(int[] nums){
        int max = nums.length; 

        int sum = 0;
        for(int num:nums){
            sum += num;            
        }
        int target = (max*(max+1))/2;

        return target-sum;        
    }
    
}
