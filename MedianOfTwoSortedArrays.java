/*There are two sorted arrays nums1 and nums2 of size m and n respectively.

        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).*/

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];

        int firstPointer = 0;
        int secondPointer = 0;
        for (int i = 0; i < array.length; i++) {
            Integer fValue = null;
            if (firstPointer <= nums1.length - 1) {
                fValue = nums1[firstPointer];
            }

            Integer sValue = null;
            if (secondPointer <= nums2.length - 1) {
                sValue = nums2[secondPointer];
            }

            if (null == fValue && null != sValue) {
                array[i] = sValue;
                secondPointer++;
                continue;
            }

            if (null == sValue && null != fValue) {
                array[i] = fValue;
                firstPointer++;
                continue;
            }

            if (fValue < sValue) {
                array[i] = fValue;
                firstPointer++;
            } else {
                array[i] = sValue;
                secondPointer++;
            }
        }

        if ((array.length % 2) != 0) {
            return array[array.length / 2];
        } else {
            int fPointer = array.length / 2;
            int sPointer = fPointer - 1;

            return ((double) array[fPointer] + (double) array[sPointer]) / 2;
        }
    }
}
