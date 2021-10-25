package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    Map partnerMap = new HashMap();

    public static void main(String args[]) {
        Solution s = new Solution();

        for (String output : s.isBalanced(new String[]{"23", "{[]}", "", "}", "()", "{{"}))
            System.out.println("Evaluating..." + output);
    }

    public String[] isBalanced(String[] input) {
        partnerMap.put('(', ')');
        partnerMap.put('{', '}');
        partnerMap.put('[', ']');
        String[] result = new String[input.length];
        int i = -1;
        for (String s : input) {
            //First increment the array index
            i++;
            System.out.println("Evaluating..." + s);
            if (s.trim().length() == 0) {
                result[i] = "Invalid";
                continue;
            }
            Stack<Character> stack = new Stack<Character>();

            for (Character c : s.toCharArray()) {
                if (c.equals('{') || c.equals('[') || c.equals('('))
                    stack.push(c);
                else if (c.equals('}') || c.equals(']') || c.equals(')')) {
                    if (stack.size() == 0) {
                        result[i] = "False";
                        break;
                    }
                    Character popChar = stack.pop();
                    if (c != partnerMap.get(popChar)) {
                        result[i] = "False";
                        break;
                    }
                } else {
                    result[i] = "Invalid";
                    break;
                }
            }

            if (result[i] != null)
                continue;

            if (stack.size() > 0)
                result[i] = "False";
            else
                result[i] = "True";

        }
        return result;
    }
}
