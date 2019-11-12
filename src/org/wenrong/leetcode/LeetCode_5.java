package org.wenrong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_5 {

    public static void main(String[] args) {


        long l = System.currentTimeMillis();
        String s = "cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj";
        System.out.println(longestPalindrome(s));
        long l1 = System.currentTimeMillis();
        System.out.println("执行时间： " + (l1 -l) + "ms");
    }

    public static String longestPalindrome2(String s) {
if(s.length() <= 1)
    return s;
for(int i = s.length();i > 0; i--) {//子串长度
 for (int j = 0; j <= s.length() - i; j++) {
String sub = s.substring(j , i + j);//子串位置
 int count = 0;//计数，用来判断是否对称
for (int k = 0; k < sub.length() / 2; k++) {//左右对称判断
if (sub.charAt(k) == sub.charAt(sub.length() - k - 1))
count++;
}
if (count == sub.length() / 2)
return sub;
}
}
 return "";//表示字符串中无回文子串

}

    public static String longestPalindrome(String s) {

        if(s.length() == 1)
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
