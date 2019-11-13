package org.wenrong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_5 {

    public static void main(String[] args) {


        long l = System.currentTimeMillis();
        String s = "cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj";

        System.out.println(longestPalindrome2(s));
        long l1 = System.currentTimeMillis();
        System.out.println("执行时间： " + (l1 -l) + "ms");
    }

    public static String longestPalindrome2(String s) {

        if(s.length() <= 1)
            return s;



        int start = 0;
        int end = 0;

        for(int i = 1 ; i < s.length();i++){

            //以i为中心点，对左右位置进行回文判断
            //基数情况
            int tempLeft = 0;
            int tempRight = 0;
            int oldLeft = i -1;
            int oldRight = i + 1;
            while(true){

                if(oldRight > s.length() - 1){
                    break;
                }

                if(s.charAt(oldLeft) == s.charAt(oldRight)){
                    tempLeft = oldLeft;
                    tempRight = oldRight;

                    oldLeft = oldLeft - 1;
                    if(oldLeft < 0){
                        break;
                    }

                    oldRight = oldRight + 1;
                    if(oldRight > s.length() - 1){
                        break;
                    }
                }else {
                    break;
                }
            }
            if(start == 0 && end == 0){

                start = tempLeft;
                end = tempRight;

            }else if((tempLeft==0&&tempRight != 0)||(tempLeft!= 0 && tempRight==0)||(tempLeft!=0&&tempRight != 0)){
                if(s.substring(tempLeft,tempRight+1).length() > s.substring(start,end+1).length()){
                    start = tempLeft;
                    end = tempRight;
                }
            }

            //偶数情况
            int evenLeft = i-1;
            int evenRight = i;
            while (true) {
                if(s.charAt(evenLeft) == s.charAt(evenRight)){
                    tempLeft = evenLeft;
                    tempRight = evenRight;
                    evenLeft = evenLeft - 1;
                    if(evenLeft < 0){
                        break;
                    }
                    evenRight = evenRight + 1;
                    if(evenRight > s.length()-1){
                        break;
                    }
                }else {
                    break;
                }
            }

            if(start == 0 && end == 0){

                start = tempLeft;
                end = tempRight;

            }else if((tempLeft==0&&tempRight != 0)||(tempLeft!= 0 && tempRight==0)||(tempLeft!=0&&tempRight != 0)){
                if(s.substring(tempLeft,tempRight + 1).length() > s.substring(start,end + 1).length()){
                    start = tempLeft;
                    end = tempRight;
                }
            }

        }

        return s.substring(start,end+1);
    }

    public static String longestPalindrome(String s) {

        if(s.length() <= 1)
            return s;


        String palindrome = "";

        for(int i = 0 ; i < s.length();i++){

            for(int j = s.length() ; j > i ;j--){

                String str = s.substring(i, j);

                if(str.length() == 1){

                    if(palindrome.length() == 0){

                        palindrome = str;

                    }

                    break;
                }

                if(str.length()%2 == 0){//偶数

                    if(str.substring(0,str.length()/2).equals(new StringBuilder(str.substring(str.length()/2)).reverse().toString())){

                        if(str.length() > palindrome.length()){
                            palindrome = str;
                        }
                    }

                }else {//基数

                    if(str.substring(0,str.length()/2).equals(new StringBuilder(str.substring(str.length()/2+1)).reverse().toString())){

                        if(str.length() > palindrome.length()){
                            palindrome = str;
                        }
                    }

                }

            }

        }

        return palindrome;
    }

}
