package org.wenrong.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用逆波兰表达式实现计算器
 */
public class Calculator {

    /**
     *
     *  1)初始化两个；运算符栈和存储中间结果的栈
     *  2）从左至右扫描中缀表达式
     *  3）遇到操作数时，将其压入结果栈
     *  4）遇到运算符是，比较其与预算符栈栈顶运算符的优先级
     *      a)如果预算符栈为空，或者栈顶部预算符为左括号，则直接将此运算符入栈
     *      b）否则，若优先级比栈顶的运算符的高，直接将运算符压入运算符栈
     *      c）否则，将运算符栈
     *
     */
    /**
     * 将中缀表达用List保存起来
     * @param midExpression
     * @return
     */
    public static List<String> midExpression2ListString(String midExpression){

        List<String> list = new ArrayList<>();
        char[] chars = midExpression.toCharArray();

        int i = 0;
        while(i < chars.length){

            if((chars[i] + "").matches("^[0-9]*$")){//是数字

                String buffer = chars[i] + "";
                i++;

                while (i < chars.length) {

                    if((chars[i] + "").matches("^[0-9]*$")){
                        buffer += chars[i] + "";
                    }else {
                        i--;
                        break;
                    }
                    i++;
                }

                list.add(buffer);
            }else {
                //非数字，直接加入
                list.add(chars[i]+"");
            }
            i++;
        }


        return list;
    }


    public static void main(String[] args) {

        List<String> strings = midExpression2ListString("10+20+(123+19)*10");
        System.out.println(strings);
    }


}
