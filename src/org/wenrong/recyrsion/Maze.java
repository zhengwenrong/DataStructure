package org.wenrong.recyrsion;

import java.util.Arrays;

/**
 * 使用递归求出迷宫的走法
 */
public class Maze {

    public static void main(String[] args) {
        int[][] arr = new int[8][7];

        for (int i = 0; i < 7; i++) {
            arr[0][i] = 1;
            arr[7][i] = 1;
        }

        for(int i = 0; i < arr.length; i ++){

            arr[i][0] = 1;
            arr[i][6] = 1;
        }

        arr[3][1] = 1;
        arr[3][2] = 1;

        setWay(arr,1,1);

        for(int i = 0 ; i < arr.length;i++){

            for(int j = 0; j < arr[i].length; j++){

                System.out.print(arr[i][j] + " ");

            }
            System.out.println();

        }





    }

    /**
     * 设置迷宫
     *
     * 规则：向下，右，上，左
     *      0：表示改点没走过
     *      1：表示墙
     *      2：表示可以走
     *      3：表示该点已经走过，但是走不通
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map,int i ,int j){

        if(map[6][4] == 2){
            return true;
        }else {

            if(map[i][j] == 0){//还没走过

                map[i][j] = 2;//设置为2,
                if(setWay(map,i + 1,j)) {//在该点的基础上向下走
                    return true;
                }else if (setWay(map,i,j+1)) {//在该点的基础上向右左
                    return true;
                }else if (setWay(map,i - 1,j)) {//在该点的基础上向上走
                    return true;
                }else if(setWay(map, i , j - 1)) {//在该点基础上向左走
                    return true;
                }else {//都走不通的情况
                    map[i][j] = 3;
                    return false;
                }

            }else {
                //已经走过了
                return false;
            }


        }
    }

}
