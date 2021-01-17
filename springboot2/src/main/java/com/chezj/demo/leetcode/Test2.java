package com.chezj.demo.leetcode;

/**
 * @description:将两个数放入链表中进行相加
 * @author: bangsun
 * @date: 2020/10/13 15:42
 */
public class Test2 {
    public static class ListNode {
        //val为存放的变量
        int val;
        //存放节点的变量
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;
        int carry = 0;
        while (l1 != null || l2 != null ) {
            int n1= l1 !=null? l1.val : 0;
            int n2= l2 !=null? l2.val : 0;
            //进位，如果为10则在下次计算的时候两个值加1，应为后面的数位高于前面的，所以达到了进位的目的
            int sumVal = n1+n2+carry;
            if (head==null){
                head=tail=new ListNode(sumVal%10);
            }else {
                tail.next=new ListNode(sumVal%10);
                tail=tail.next;
            }
            carry= sumVal / 10;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry>0){
            tail.next=new ListNode(carry);
        }
        return  head;
    }

    public static void main(String[] args) {
        Test2 test2=new Test2();
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(4,listNode1);
        ListNode listNode3=new ListNode(3,listNode2);
        ListNode listNode4=new ListNode(5);
        ListNode listNode5=new ListNode(6,listNode1);
        ListNode listNode6=new ListNode(4,listNode2);
        test2.addTwoNumbers(listNode1,listNode4);
    }
}
