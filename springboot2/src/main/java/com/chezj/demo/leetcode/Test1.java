package com.chezj.demo.leetcode;

import java.util.HashMap;

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
        test.twoSum1(nums, 9);
    }
}
