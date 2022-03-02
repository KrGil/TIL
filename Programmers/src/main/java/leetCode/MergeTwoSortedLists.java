package leetCode;

import com.tistory.eisen.Eisen;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * packageName : leetCode
 * fileName : MergeTwoSortedLists
 * author :  eisen
 * date : 2022/02/25
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/02/25                eisen             최초 생성
 */

public class MergeTwoSortedLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args) {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        // list1
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        // list2
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = mtsl.mergeTwoLists(list1, list2);
        System.out.println("result = " + result);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // tail에게 head의 주소값을 바라보게.
        // head가 곧 tail임.
        // tail.next = head.next와 동일하게 만듦.
        ListNode head = new ListNode();
        ListNode tail = head;

        while(list1 != null && list2 != null ){

            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // list1이 null이면 list2를 넣고 아니면 1.
        tail.next = list1 == null ? list2: list1;

        return head.next;
    }
}
//그리구 나중에 바꾼건
//
//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//        ListNode head = new ListNode();
//        ListNode tail = head;
//
//        while (list1 != null && list2 != null) {
//
//            if (list1.val < list2.val) {
//                tail.next = list1;
//                list1 = list1.next;
//            } else {
//                tail.next = list2;
//                list2 = list2.next;
//            }
//            tail = tail.next;
//        }
//
//        tail.next = list1 == null ? list2 : list1;
//
//        return head.next;
//    }


//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//        ListNode head = new ListNode();
//        ListNode tail = head;
//
//        while (list1 != null || list2 != null) {
//            if (list1 == null) {
//                tail.next = new ListNode(list2.val);
//                tail = list2.next;
//            } else if (list2 == null) {
//                tail.next = new ListNode(list1.val);
//                tail = list1.next;
//            } else {
//                if (list1.val < list2.val) {
//                    tail.next = new ListNode(list1.val);
//                    list1 = list1.next;
//                } else {
//                    tail.next = new ListNode(list2.val);
//                    list2 = list2.next;
//                }
//            }
//
//            list2 = list2.next;
//        }
//
//        return head.next;
//    }