package MaiJavaTools.DataStructure;

public class FindMedianOfTwoArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return 0.0;
        //throw IllegalArgumentException("Two arrays cannot be null");

        int[] nums = null;

        if(nums1 == null)
            nums = nums2;
        else if(nums2 == null)
            nums = nums1;
        else {
            int len = nums1.length + nums2.length;
            nums = new int[len];
            int i1=0, i2=0;
            for(int i =0; i<len; i++){
                if(i1 >= nums1.length){
                    nums[i] = nums2[i2];
                    i2++;
                } else if(i2 >= nums2.length){
                    nums[i] = nums1[i1];
                    i1++;
                } else if(nums1[i1] < nums2[i2]){
                    nums[i] = nums1[i1];
                    i1++;
                }
                else {
                    nums[i] = nums2[i2];
                    i2++;
                }
            }
        }
        if(nums.length % 2 == 0){
            int mid = nums.length / 2;
            double sum = (double)nums[mid-1] + (double)nums[mid];
            return sum/2;
        } else {
            return nums[nums.length/2];
        }

    }
}
