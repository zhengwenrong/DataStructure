package org.wenrong.problem;

/**
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？
 * 序分析：兔子的规律为数列1,1,2,3,5,8,13,21….
 */
public class Problem_1 {

    public static void main(String[] args) {


        System.out.println(count(6));


    }

    public static int count(int month){

        if(month == 2 || month == 1){

            return 1;
        }


        return count(month-1) + count(month -2);
    }


}
