package solution;

/*
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class T_004 {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int midleft = (len1 + len2 + 1)/2;
        int midright = (len1+len2+2)/2;
        return (findKth(nums1, 0, nums2, 0, midleft)+findKth(nums1, 0, nums2, 0, midright))/2.0;
    }

    /**
     * 
     * @param nums1 
     * @param beg1  nums1的起始下标
     * @param nums2
     * @param beg2  nums2的起始下标
     * @param k 需要查找的第k的
     * @return
     */
    private double findKth(int[] nums1, int beg1, int[] nums2, int beg2, int k){
        if(beg1 >= nums1.length) return nums2[beg2+k-1];
        if(beg2 >= nums2.length) return nums1[beg1+k-1];
        if(k == 1){
            return Math.min(nums1[beg1], nums2[beg2]);
        }
        int midVal1 = (beg1 + k/2 -1 < nums1.length)?nums1[beg1+k/2-1] : Integer.MAX_VALUE;
        int midVal2 = (beg2 + k/2 -1< nums2.length)?nums2[beg2+k/2-1] : Integer.MAX_VALUE;
        
        if(midVal1 < midVal2){
            return findKth(nums1, beg1+k/2, nums2, beg2, k-k/2);
        }else{
            return findKth(nums1, beg1, nums2, beg2+k/2, k-k/2);
        }
    }
}
