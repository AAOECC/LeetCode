import solution.*;
import utils.FileUtil;

/**
 * 测试主程序
 */
public class Run{

    private static int[] nums = {9,6,4,2,3,5,7,0,1};

    public static void main(String[] args) {        
        System.out.println("本次新增题解个数为："+FileUtil.updateReadme());
        
        T_703 kthLargest = new T_703(3,new int[]{4, 5, 8, 2});
        
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8

    }
    
      
}