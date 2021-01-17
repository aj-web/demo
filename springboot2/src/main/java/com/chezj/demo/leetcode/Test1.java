package com.chezj.demo.leetcode;

import org.apache.commons.lang.enums.Enum;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:leetcode第一题
 * @author: bangsun
 * @date: 2020/10/13 11:13
 */
public class Test1 {
    /**
     * @description:循环遍历数组
     * @author: bangsun
     * @date: 2020/10/13 14:46
     No such property: code for class: Script1
     * @return: int[]
     */
    public int[] twoSum(int[] nums, int target) {
        int[] s = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    s[0] = i;
                    s[1] = j;
                    System.out.println("s[0]为" + s[0] + " s[1]为" + s[1]);
                    return s;
                }
            }
        }
        return s;
    }

    /**
     * @description: 查找target减去第一个数后的值，是否存在数组中，有就返回
     * @author: bangsun
     * @date: 2020/10/13 14:43
    No such property: code for class: Script1
     * @return: int[]
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] s = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(target - nums[i]) == null) {
                hashMap.put(nums[i], i);
            } else {
                s[0] = hashMap.get(target - nums[i]);
                s[1] = i;
                System.out.println("s[0]为" + s[0] + " s[1]为" + s[1]);
                return s;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        int[] nums = {2, 7, 9, 11};
        test.myTwoSum(nums, 9);
        int k =1;
        int[] nums1=new int[2];
        System.out.println(k-nums1[0]);
    }

    public  int[] myTwoSum(int[] ints,int target){
        int[] s= new int[2];
        Map map = new HashMap(2);
        for (int j=0;j<ints.length;j++){
            if ((map.get(target-ints[j]) == null)){
                map.put(ints[j],j);
            }else {
                s[0]=j;
                s[1]=Integer.parseInt(map.get(target-ints[j]).toString());
            }
        }
        System.out.println("s[0]为" + s[0] + " s[1]为" + s[1]);
        return s;
    }
}
