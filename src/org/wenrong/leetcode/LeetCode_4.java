package org.wenrong.leetcode;

import java.util.Arrays;

public class LeetCode_4 {

    public static void main(String[] args) {

        int nums1[] = {1, 2};
        int nums2[] = {3,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);

        System.out.println(2/2);

    }



    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int num3[] = new int[nums1.length + nums2.length];
        int index = 0;
        for(int i : nums1){
            num3[index] = i;
            index++;
        }

        for(int i : nums2){
            num3[index] = i;
            index++;
        }

        Arrays.sort(num3);

        double middle = 0;

        if(num3.length%2==0){
            double i = num3[num3.length / 2];
            double j =num3[(num3.length/2)-1];
            middle = (i + j)/2;
        }else {
           middle = num3[num3.length /2];
        }

        return middle;
    }

}
