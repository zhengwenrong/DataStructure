package org.wenrong.leetcode;

import java.util.Stack;

public class LeetCode_7 {

    public static void main(String[] args) {

        String s = "-1";

        int i = Integer.MAX_VALUE;

        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {

        Stack stack = new Stack();

        String str = x+"";

        boolean negative = false;

        if(str.indexOf("-")==0){
            negative = true;
            str = str.substring(1);
        }

        char[] chars = str.toCharArray();

        int length = chars.length;
        for(int i = 0 ; i < length; i++){

            if(i == length - 1 && chars[i] == 0){

                continue;
            }
            stack.push(chars[i]);
        }

        String numberStr = "";

        while(!stack.isEmpty()){

            numberStr += stack.pop();

        }

        if(negative)
            numberStr = "-" + numberStr;

        long l = Long.parseLong(numberStr);
        if(l > Integer.MAX_VALUE){
            return 0;
        }else if(l < Integer.MIN_VALUE){
            return 0;
        }else {

            return ((int) l);
        }

    }

}
