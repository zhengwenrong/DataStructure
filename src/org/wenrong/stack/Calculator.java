package org.wenrong.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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


    /**
     * 中缀表达式a + b*c + (d * e + f) * g，其转换成后缀表达式则为a b c * + d e * f  + g * +。
     *
     * 转换过程需要用到栈，具体过程如下：
     *
     * 1）如果遇到操作数，我们就直接将其输出。
     *
     * 2）如果遇到操作符，则我们将其放入到栈中，遇到左括号时我们也将其放入栈中。
     *
     * 3）如果遇到一个右括号，则将栈元素弹出，将弹出的操作符输出直到遇到左括号为止。注意，左括号只弹出并不输出。
     *
     * 4）如果遇到任何其他的操作符，如（“+”， “*”，“（”）等，从栈中弹出元素直到遇到发现更低优先级的元素(或者栈为空)为止。弹出完这些元素后，才将遇到的操作符压入到栈中。有一点需要注意，只有在遇到" ) "的情况下我们才弹出" ( "，其他情况我们都不会弹出" ( "。
     *
     * 5）如果我们读到了输入的末尾，则将栈中所有元素依次弹出。
     */
    public static void fun(String expression){

        //中缀表达式a + b*c + (d * e + f) * g，其转换成后缀表达式则为a b c * + d e * f  + g * +。

        /*
        1）如果遇到操作数，我们就直接将其输出。

        2）如果遇到操作符，则我们将其放入到栈中，遇到左括号时我们也将其放入栈中。

        3）如果遇到一个右括号，则将栈元素弹出，将弹出的操作符输出直到遇到左括号为止。注意，左括号只弹出并不输出。

        4）如果遇到任何其他的操作符，如（“+”， “*”，“（”）等，从栈中弹出元素直到遇到发现更低优先级的元素(或者栈为空)为止。弹出完这些元素后，才将遇到的操作符压入到栈中。有一点需要注意，只有在遇到" ) "的情况下我们才弹出" ( "，其他情况我们都不会弹出" ( "。

        5）如果我们读到了输入的末尾，则将栈中所有元素依次弹出。

        */
        List<String> strings = midExpression2ListString(expression);

        String result = "";

        Stack stack = new Stack();

        for (String s : strings) {

            if(s.matches("^[0-9]*$")){

                    result += s;

            }else if(s.contains(")")){

                while(!stack.isEmpty()){

                    String pop = (String) stack.pop();

                    if(pop.contains("(")) {

                        break;
                    }else {
                        result += pop;
                    }
                }


            }else {

                //栈顶元素
                if(stack.isEmpty()){
                    stack.push(s);
                }else {
                    String top = (String) stack.peek();

                    if( s == top){
                        //a+b*c+(d*e+f)*g

                    }

                }

            }

        }

    }





    public static void main(String[] args) {


        String a = "+";
        String b = "-";
        String c = "*";
        String d = "/";

        System.out.println(a.compareTo(d));

    }


}
