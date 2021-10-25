package com.coding.practice;

import java.util.*;

public class DPMemoization {
    public static Map<String,Boolean> canConstructMap = new HashMap<>();
    public static Map<String,Integer> countConstructMap = new HashMap<>();
    public static void main(String[] args)
    {
       /* System.out.println("Can Sum:");
        System.out.println(canSum(8,new int[]{2,3,4,5}));
        System.out.println(canSum(11,new int[]{2,3,4}));
        System.out.println("Count sum:");
        System.out.println(countSum(8,new int[]{2,3,4,5}));
        System.out.println(countSum(8,new int[]{3,4,5})); */
        System.out.println("All sum:");
        System.out.println(allSum(7,new int[]{3,4,5}));
        System.out.println("Best Sum");
        System.out.println(bestSum(7, new int[]{2,3,4,5,7}));


        /*System.out.println("can Construct");
        boolean canConstruct = canConstruct("abcdef",new String[]{"ab","abc","cd","def","ef"});
       System.out.println(canConstruct);
        canConstruct = canConstructTab("abcdef",new String[]{"ab","abc","cd","def","ef"});
        System.out.println("Tab:"+canConstruct);
       canConstruct = canConstruct("abcdeff",new String[]{"ab","abc","cd","def","ef"});
        System.out.println(canConstruct);
        canConstruct = canConstructTab("abcdeff",new String[]{"ab","abc","cd","def","ef"});
        System.out.println("Tab:"+canConstruct);
        canConstruct = canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeefff",new String[]{"e","ee","eee","eeee","eeeeeefff"});
        System.out.println(canConstruct);
        canConstruct = canConstructTab("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeefff",new String[]{"e","ee","eee","eeee","eeeeeefff"});
        System.out.println("Tab:"+canConstruct);*/
        /*System.out.println("Count Total:");
        System.out.println(countConstruct("abcdef",new String[]{"ab","abc","cd","def","ef"}));
        System.out.println(countConstruct("abcdeff",new String[]{"ab","abc","cd","def","ef"}));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeefff",new String[]{"e","ee","eee","eeee","eeeeeefff"}));
       */
    }

    public static List<Integer> bestSum(int target,int[] nums)
    {
        List<Integer> result=null;
        if(target==0)
            return new ArrayList<>();
        if(target<0)
            return null;
        for(int num:nums)
        {
            List<Integer> res = bestSum(target-num,nums);
            if(res!=null)
            {
                res.add(num);
                if(result==null|| result.size()>res.size())
                    result = res;
            }
        }
        return result;
    }
    public static boolean canConstructTab(String target,String[] words)
    {
        boolean[] dp=new boolean[target.length()+1];
        dp[0]= true;
        for(int i=0;i<target.length();i++)
        {
            if(dp[i]==true)
            {
                for(String word:words)
                {
                    if(i+word.length() <=target.length() && target.substring(i,i+word.length()).equals(word))
                    {
                        dp[i+word.length()]=true;
                    }
                }
            }
        }
        return dp[target.length()];
    }
    public static List<List<Integer>> allSum(int target,int[] nums)
    {
        if(target==0)
            return new ArrayList<>();
        if(target<0)
            return null;
        List<List<Integer>> waysSum=null;
        for(int num:nums) {
            List<List<Integer>> list = allSum(target - num, nums);
            if (list != null) {
                if (list.size() == 0) {
                    list.add(new ArrayList<>());
                }
                list.forEach(l -> l.add(num));
                if (waysSum == null)
                    waysSum = new ArrayList<>();
                waysSum.addAll(list);
            }
        }
        return waysSum;
    }
    public static int countSum(int target,int[] nums)
    {
        if(target==0)
            return 1;
        int count=0;
        for(int num:nums) {
            if (target - num >=0)
                count += countSum(target - num, nums);
        }
        return count;
    }
    public static boolean canSum(int target,int[] nums,int[] memo)
    {
       //if(memo[target])
        if(target==0)
           return true;
       for(int num:nums)
       {
           if(target-num>=0)
             return canSum(target-num,nums,memo);
       }
        return false;
    }
    public static boolean canConstruct(String target,String[] words)
    {
        if(canConstructMap.containsKey(target))
            return canConstructMap.get(target);

        if(target!=null && target.equals("") )
            return true;
        boolean result = false;
        for(int i=0;i<words.length;i++)
        {
            if(target.startsWith(words[i]))
            {
                result = canConstruct(target.substring(words[i].length()),words);
            }
        }
        canConstructMap.put(target,result);
        return result;
    }

    public static int countConstruct(String target,String[] words)
    {
        if(countConstructMap.containsKey(target))
            return countConstructMap.get(target);
        if(target.equals(""))
            return 1;
        int totalNoOfWays =0;
        for(int i=0;i<words.length;i++)
        {
            if(target.startsWith(words[i]))
                totalNoOfWays+=countConstruct(target.substring(words[i].length()),words);
        }
        countConstructMap.put(target,totalNoOfWays);
        return totalNoOfWays;
    }

}
