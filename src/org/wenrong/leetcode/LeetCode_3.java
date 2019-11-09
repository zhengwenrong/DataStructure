package org.wenrong.leetcode;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.*;


public class LeetCode_3 {




    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static int lengthOfLongestSubstring( String s) {

        if(s.length() == 1)
            return 1;
        int maxLength = 0;

        char[] chars = s.toCharArray();

        for(int i = 0;i < chars.length; i++){
            Map<Character,Character> tempMap = new HashMap<>();
            String buffer = "";
            for(int j = i;j < chars.length; j++){

                if(null == tempMap.get(chars[j])){

                    tempMap.put(chars[j],chars[j]);
                    buffer += chars[j];
                }else{

                    int newLength = buffer.length();
                    if(newLength > maxLength)
                        maxLength = newLength;
                    tempMap.clear();
                    break;
                }

            }

            if(tempMap.size() != 0){
                int newLength = buffer.length();
                if(newLength > maxLength)
                    maxLength = newLength;
            }

        }

        return maxLength;
    }
}
