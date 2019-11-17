package org.wenrong.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeetCode_6 {

    public static String convert(String s, int numRows) {

        if(s.length() == 1 || numRows == 1)
            return s;

        int size = 2 * numRows - 2 ;

        List<Character> listArr[] = new ArrayList[numRows];

        for(int i = 0; i < numRows;i++)
            listArr[i] = new ArrayList();

        int direction = -1;

        char[] chars = s.toCharArray();
        int length = chars.length;
        for(int i = 0 ; i < length ;i++){

            if(i!= 0 &&i % size == 0)
                direction = -1;

            if(i % size >=  numRows ){

                direction--;
                listArr[direction].add(chars[i]);

            }else {
                direction++;
                listArr[direction].add(chars[i]);

            }

        }

        String ss = "";

        for(List list:listArr){

            for(Object c : list){

                ss += c;

            }
        }

        return ss;
    }


    public static void main(String[] args) throws IOException {

        String s = "abc";

        System.out.println(convert(s,2));



    }
}
