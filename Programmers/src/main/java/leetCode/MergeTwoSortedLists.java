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
        // binary search
        // recursive
        // list2.next = listTmp
        // listTmp.next
        ListNode listTmp = new ListNode();
        listTmp.next = new ListNode(1);

        // todo
        // 1. 둘 모두 null이 아닐 경우
        //  1-1. a와 b 비교 후 a가 작을 시 a를 listTmp.val에 할당
        //  1-1-1. b의 값을 다음 loop에 사용할 수 있도록 .next로 할당
        //  1-1-2. .next의 값을 다음 loop의 .val로 사용하게끔 listTmp에 할당(listTmp = listTmp.next)
        //  1-1-3. ArrayList result에 값 추가.
        //  1-2. a와 b 비교 후 b가 작을 시 b를 listTmp.val에 할당
        //  1-1-1. 위의 과정 반복

        // 2. list1이 null이고 list2가 null이 아닐 경우
        // 2-1. list2의 값을
        // 3. list1이 null이 아니고 list2가 null일 경우


        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode result = new ListNode();
        while(list1 != null || list2 != null ){

            // 2. list1이 null일 때
            // 3. list1이 null일 때
            if (list1 == null) {
                System.out.println("list1 == null && list2 != null");
                return null;
            } else if (list2 == null) {
                System.out.println("list1 != null && list2 == null");
                return null;
            } else{
                // 1.
                System.out.println("list1 = " + list1.val + "  list2 = " + list2.val);

                if (list1.val <= list2.val) {
                    System.out.println("list1 < list2");

                    listTmp.val = list1.val;
                    result.next = new ListNode();
                    result = result.next;
                    System.out.println("listTmp = " + listTmp);

                    list1 = list1.next;
                } else {
                    System.out.println("list1 > list2");

                    listTmp.val = list2.val;
                    System.out.println("listTmp = " + listTmp);

//                    result.add(listTmp.val);
                    listTmp.next = new ListNode(list1.val);
                    listTmp = listTmp.next;

                    list2 = list2.next;
                }
            }
            // 4. 둘 다 null 일 경우
        }
        return null;
    }
}
//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//        ListNode list1.val = new ListNode();
//        ListNode list2 = list1.val;
//
//        while (list1 != null || list2 != null) {
//
//            if (list1 == null) {
//                list2.next = new ListNode(list2.val);
//                list2 = list2.next;
//            } else if (list2 == null) {
//                list2.next = new ListNode(list1.val);
//                list1 = list1.next;
//            } else {
//                if (list1.val < list2.val) {
//                    list2.next = new ListNode(list1.val);
//                    list1 = list1.next;
//                } else {
//                    list2.next = new ListNode(list2.val);
//                    list2 = list2.next;
//                }
//            }
//
//            list2 = list2.next;
//        }
//
//        return list1.val.next;
//    }