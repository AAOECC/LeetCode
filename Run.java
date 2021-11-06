import solution.*;
import utils.FileUtil;

/**
 * 测试主程序
 */
public class Run{

    private static int[] nums = {9,6,4,2,3,5,7,0,1};

    public static void main(String[] args) {        
        System.out.println("本次新增题解个数为："+FileUtil.updateReadme());
        
        T_268 solution = new T_268();
        int result = solution.missingNumber(nums);
        System.out.println(result);
    }
    
      
}
