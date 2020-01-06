package org.wenrong.recyrsion;

/**
 * 八皇后问题
 */
public class Queen {

    //皇后数量
    int MAX = 8;

    /**
     * 数组，数组下标表示第i+1个皇后，放到arr[i] + 1个位置上
     */
    int[] arr = new int[MAX];

    static int count = 0;

    public static void main(String[] args) {
        new Queen().check(0);
        System.out.printf("共有%d种摆法",count);
    }

    public void check(int n){

        if(n == MAX){//表示要放最后一个位置

            print();
            return;
        }else {

            for(int i = 0 ; i < MAX;i++){

                //表示第n个皇后放到i这里，这里会进行回溯
                arr[n] = i;
                if(judge(n)){
                    check(n +1);
                }

            }
        }
    }

    /**
     * 检查这个皇后在棋盘的位置是否合法
     * @param n 表示第几个皇后
     * @return
     */
    public boolean judge(int n){

        //只判断到第n个位置
        for(int i = 0; i < n;i++){

            //表示放到同一列了
            if(arr[i] == arr[n]){
                return false;
            }

            //表示在同一斜线上
            if(Math.abs(n-i) == Math.abs(arr[n] - arr[i])){

                return false;
            }
        }

        return true;
    }



    private void print(){
        count++;
        for(int i = 0; i < MAX;i++){
            System.out.print(arr[i]);
        }

        System.out.println();
    }

}
