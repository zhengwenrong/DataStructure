package org.wenrong.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 思路：
 *      两个循环，两个数两两比较，将最大的数放到最后，下次就不用最后的数进行比较
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[10000];//{2,34,543,234,1,36,5,234,45,45,65,56,6,7,7};
        Random random = new Random();
        for(int i = 0;i < 10000;i ++){

            arr[i] = random.nextInt(1000);
        }

        long start = System.currentTimeMillis();

        for(int i = arr.length - 1; i > 1 ;i--){ // 循环的次数

            for(int j = 0; j < i; j++){

                if(arr[j] > arr[j + 1]){

                    //交换
                    int temp = arr[j];
                    arr[j]= arr[j + 1];
                    arr[j + 1] = temp;

                }

            }

        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Arrays.toString(arr));


    }

}
