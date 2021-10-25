package com.coding.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args)
    {
        System.out.println("Hello");
        EvaluateExpression e = new EvaluateExpression();
        String number="234";
        System.out.println(e.stringToInt(number));
        System.out.println("Postfix expr:"+e.evaluatePostfix("231*+9-"));
    }

    public int evaluatePostfix(String expr)
    {
        int result=0;
        Set<Character> op = new HashSet<>();
        op.add('+');    op.add('-');   op.add('*');    op.add('/');
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<expr.length();i++)
        {
            Character c= expr.charAt(i);
            if(!op.contains(c))
            {
                stack.push(c-'0');
            }
            else
            {
                int val1= stack.pop();
                int val2= stack.pop();
                if(c=='+')
                    stack.push(val1+val2);
                else if(c=='-')
                    stack.push(val1-val2);
                else if(c=='*')
                    stack.push(val1*val2);
                else if(c=='/')
                    stack.push(val1/val2);
            }
        }
        return stack.pop();
    }

    public int stringToInt(String number)
    {
        int num=0;
        for(int i=0;i<number.length();i++)
        {
           num = num*10 + number.charAt(i)-'0';
        }
        return num;
    }

}
