package com.chezj.demo.leetcode;

import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @description:
 * @author: bangsun
 * @date: 2020/10/14 15:05
 */
public class Test3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("") ||s.equals(null)){
            return 0;
        }
        int MAX=0;
        int left=0;
        int le=s.length();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int start=0;start<le;start++){
            if (hashMap.containsKey(s.charAt(start))){
                left=Math.max(left,hashMap.get(s.charAt(start))+1);
            }
            hashMap.put(s.charAt(start),start);
            MAX=Math.max(left,start-left+1);
        }

        return MAX;
    }

    public static void main(String[] args) {
        Test3 test3=new Test3();
        String s="dhkasjhfiuahfanjg";
        test3.lengthOfLongestSubstring(s);
    }
}
