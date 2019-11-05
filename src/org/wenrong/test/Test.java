package org.wenrong.test;

public class Test {

    public static void main(String[] args) {

        try {
            int i = 1/0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(test());

    }

    public static int test(){

        int x =1;

        try{

            return x;
        }finally {

            x++;

        }

    }

}
