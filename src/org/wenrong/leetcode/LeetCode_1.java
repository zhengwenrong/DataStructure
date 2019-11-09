package org.wenrong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 {

    public static void main(String[] args) {




    }

    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++){

            if(i != 0){
                int diff = target - nums[i];

                if(null != map.get(diff)){

                    result[0] =map.get(diff);
                    result[1] = i;
                    break;
                }
            }
            map.put(nums[i],i);
        }


        return result;
    }

}
