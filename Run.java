import java.util.List;

import solution.T_015;
import solution.*;

/**
 * 测试主程序
 */
public class Run{

    private static int[] sum = {-1,0,1,2,-1,-4};

    public static void main(String[] args) {
        T_015 solution = new T_015();
        List<List<Integer>> threeSum = solution.threeSum(sum);
        for (List<Integer> list : threeSum) {
            System.out.println(list);
        }
        
    }
    
}
