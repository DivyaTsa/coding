package com.test;

import java.util.*;

public class Test {
    public static Set<Character> openBr = new TreeSet<Character>();
    public static Set<Character> closeBr = new TreeSet<Character>();
    public static Map<Character, Character> openCloseMap = new HashMap<Character, Character>();

    public static void main(String[] args) {
        Test t = new Test();
        String str1 = new String("Test");
        String str2 = new String("test");
        System.out.println("Equals ignore:" + str1.equalsIgnoreCase(str2));
        StringBuilder sb = new StringBuilder("Test Str");
        System.out.println("String:" + sb.toString() + "  - Reverse:" + sb.reverse());
		
		/*double a = 100;
		double d = a/0;
		System.out.println(d);
		for(int i=10;i<18;i++)
		 System.out.println(i+i>>1);*/
		/*byte b1 = 2;
		byte b2= 0;
		byte b3 = b1+b2;*/
		/*Test t = new Test();
		Long l = new Long(4);
		System.out.println(l);
		add(l);
		System.out.println(l);
		String s =  "7";
		System.out.println(s);
		add(s);
		System.out.println(s);*/
        // TODO Auto-generated method stub
		/*double x = 7/4;
		System.out.println(x);
		int[] array = new int[10];*/
        //t.duck();
		/*System.out.println("Hello");
		 
		String[] test = {"()","(}" };
		String[] result = isBalanced(test);
		for (String string : result) {
			System.out.println(string);
		}*/
    }

    private static void add(String s) {
        s += 2;
        System.out.println(s);

    }

    private static void add(Long l) {
        l += 2;
        System.out.println(l);
    }

    public static String[] isBalanced(String[] input) {
        openCloseMap.put('(', ')');
        openCloseMap.put('[', ']');
        openCloseMap.put('{', '}');
        openBr.addAll(Arrays.asList(new Character[]{'(', '[', '{'}));
        closeBr.addAll(Arrays.asList(new Character[]{')', ']', '}'}));
        int length = input.length;
        String[] result = new String[length];
        Stack<Character> stack;

        for (int i = 0; i < length; i++) {
            String testStr = input[i];
            System.out.println("String :" + testStr);
            stack = new Stack();
            for (int j = 0; j < testStr.length(); j++) {
                Character c = testStr.charAt(j);
                if (openBr.contains(c))
                    stack.push(c);
                if (closeBr.contains(c)) {
                    Character c1 = stack.pop();
                    if (!c1.equals(openCloseMap.get(c1))) {
                        result[i] = "False";
                        break;
                    }
                }
            }
            if (result[i] == null && stack.empty())
                result[i] = "True";

        }
        return result;
    }

    public void duck() {
        int i = goose();
        System.out.println(i);
    }

    private int goose() {
        System.out.println("P ");
        try {
            return swan(2);
        } catch (Exception e) {
            System.out.println("Q ");
        } finally {
            System.out.println("R ");
        }
        return 4;
    }

    private int swan(int j) throws Exception {
        System.out.println("S ");
        try {
            if (j == 2)
                throw new Exception();
            System.out.println("T ");
            return j;
        } finally {
            System.out.println("U ");
        }
        //return 0;
    }

}
