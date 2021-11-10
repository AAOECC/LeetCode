package solution;

import java.util.PriorityQueue;

/*
设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。

请实现 KthLargest 类：

KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/**
 * have problem
 */
public class T_703 {
    public KthLargest kthLargest;
    public T_703(int k, int[] nums){
        kthLargest = new KthLargest(k, nums);
    }
    //public KthLargest kthLargest = new KthLargest();
    
    public int add(int val){
        int res = kthLargest.add(val);
        System.out.println(res);
        return res;
    }
}

class KthLargest{
    int[] pq;
    int k;

    public KthLargest(int k, int[] nums){
        this.k = k;
        pq = new int[k+1];
        int i = 0;
        for(;i<k-1; i++){
            pq[i] = nums[i];
        }
        if(nums.length == k-1){
            pq[k-1] = Integer.MIN_VALUE;
        }else{
            pq[k-1] = nums[k-1];
        }
        for(;i>0; i--){
            if(pq[i] < pq[(i-1)/2]){
                int num = pq[i];
                pq[i] = pq[(i-1)/2];
                pq[(i-1)/2] = num;
            }
        }
        for(int j=k; j<nums.length; j++){
            add(nums[j]);
        }

    }

    public int add(int val){
        if(val > pq[0]){
            pq[0] = val;
            format(0);
        }
        return pq[0];
    }

    private void format(int idx){
        int left = (idx << 1) + 1;
        int right = (idx << 1) +2;
        int min;
        if(left > k-1) return ;
        if(right > k-1 || pq[left] < pq[right]) {
            min = pq[left];
            pq[left] = pq[idx];
            pq[idx] = min;
            format(left);
        }else if(pq[right] < pq[left]){
            min = pq[right];
            pq[right] = pq[idx];
            pq[idx] = min;
            format(right);
        }
    }
}
