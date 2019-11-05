package org.wenrong.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args){

        Object[][] objects = {{0,0,1,0,2},{0,1,0,1,1},{0,2,1,0,2},{2,0,1,1,2},{0,1,1,1,2},{0,1,1,1,2}};
        Object[][] objects1 = array2SparseArray(objects);


        Object[][] objects2 = sparseArray2Array(objects1);

        System.out.println();

    }

    /**
     * 二维数组转稀疏数组
     * @return
     */
    public static Object[][] array2SparseArray(Object[][] array){

        if(array.length == 0){
            throw new IllegalArgumentException("transform fail");
        }

        //查询二维数组中有效数据的数量
        int  validCount = 0;
        int validArr[][] = new int[1][3];

        int xRow[] = new int[array.length * array[0].length];
        int yRow[] = new int[array.length * array[0].length];
        Object value[] = new Object[array.length * array[0].length];

        for(int i = 0;i<array.length;i++){

            for(int j = 0; j < array[i].length;j++){

                if(null != array[i][j]&&(int)array[i][j] != 0){
                    xRow[validCount] = i;
                    yRow[validCount] = j;
                    value[validCount] = array[i][j];
                    validCount++;

                }
            }
        }

        //创建一个稀疏数组
        Object[][] sparseArray = new Object[validCount +1][3];

        //第一行保存数据有多少行和多少列
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = 2;

        for(int i = 1;i < sparseArray.length;i++){

            int temp = 0;
            sparseArray[i][temp] = xRow[i - 1];
            sparseArray[i][++temp] = yRow[i -1];
            sparseArray[i][++temp] = value[i -1];
        }

        return sparseArray;
    }

    /**
     * 稀疏数组转二维数组
     * @param sparseArray
     * @return
     */
    public static Object[][] sparseArray2Array(Object[][] sparseArray){

        if(sparseArray.length == 0){
            throw new IllegalArgumentException("transform fail");
        }

        Object[][] array = new Object[(int)sparseArray[0][0]][(int)sparseArray[0][1]];


        for(int i = 0; i < array.length;i++){

            for(int j = 0; j < array[i].length;j++){

                array[i][j] = 0;

            }

        }

        for(int i = 1;i < sparseArray.length;i++){

            array[(int)sparseArray[i][0]][(int)sparseArray[i][1]] = sparseArray[i][2];

        }

        return array;
    }

}
