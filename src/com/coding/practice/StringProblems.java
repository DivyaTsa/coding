package com.coding.practice;

import java.util.Arrays;
import java.util.Stack;

public class StringProblems {
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        String s = "*|**|*|**|***|||*|";
        int[] startIndices= {1,2,3,3};
        int[] endIndices= {5,6,7,s.length()};
        //itemsInContainer(s,startIndices,endIndices);
        removeDuplicates("",2);
        String expr ="a(b){2}";
        evaluateStringExpr(expr);
    }

    public static void evaluateStringExpr(String str)
    {
        if(str==null || str=="")
        {
            return;
        }
        int i=0;
        StringBuilder result = new StringBuilder();
        while(i<str.length())
        {
            char c = str.charAt(i);

        }
    }

    public static void removeDuplicates(String s, int k)
    {
        s="deeedbbcccbdaa";  //"pbbcggttciiippooaais";
        k=3;   //2;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            int j=k-1;
            Stack<Character> tempS=new Stack<>();
            while(!stack.isEmpty() && stack.peek()==c && j>0)
            {
                tempS.push(stack.pop());
                j--;
            }
            while(j!=0 && !tempS.isEmpty())
            {
                stack.push(tempS.pop());
            }
            if(j!=0)
                stack.push(c);
            else tempS.clear();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb);
    }
    public static int[] itemsInContainer(String s, int[] startIndices,int[] endIndices) {
        int[] result = new int[startIndices.length];
        for (int i = 0; i < startIndices.length; i++) {
            int count=0;
            String subStr = s.substring(startIndices[i], endIndices[i]);
            System.out.println(subStr);
            int start = subStr.indexOf('|');
            int end= subStr.lastIndexOf('|');
            System.out.print("Start:"+start+",End:"+end);
            while(start<end)
            {
                if(subStr.charAt(start++)=='*')
                    count++;
            }
            System.out.println(", count:"+count);
            result[i] = count;
        }
        return result;
    }
}
