package leetCode;

import com.tistory.eisen.Eisen;

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

        while(list1 != null || list2 != null ){
            System.out.println("list1 = " + list1.val+ "  list2 = " + list2.val);
            int list1Tmp = list1.val;
            int list2Tmp = list2.val;

            // todo
            // current .next.val => to current .val
            // first compare
            if (list1Tmp <= list2Tmp) {
                // add smaller val to .val
                listTmp.val = list1Tmp;
                System.out.println("list2Tmp = " + list2Tmp);

                // add larger val to .next.val
                if ((Integer)list2Tmp != null) {
                    listTmp.next = new ListNode(list2Tmp);
                }
                listTmp.next.val = list2Tmp;
                listTmp = listTmp.next;

                // reset
                list1Tmp = list1.next.val;
                list2Tmp = list2.val;

                list1 = list1.next;

            } else {
                // todo
                // copy
                // add smaller value to listTmp.val
                listTmp.val = list2Tmp;
                listTmp = listTmp.next;

                // add larger value to listTmp.next.val
                listTmp.val = list1Tmp;
                System.out.println("list2Tmp = " + list2Tmp);
                // reset
                list1Tmp = list1.val;
                list2Tmp = list2.next.val;



                list2 = list2.next;
            }


        }
        return null;
    }
}
//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//        ListNode list1Tmp = new ListNode();
//        ListNode list2Tmp = list1Tmp;
//
//        while (list1 != null || list2 != null) {
//
//            if (list1 == null) {
//                list2Tmp.next = new ListNode(list2.val);
//                list2 = list2.next;
//            } else if (list2 == null) {
//                list2Tmp.next = new ListNode(list1.val);
//                list1 = list1.next;
//            } else {
//                if (list1.val < list2.val) {
//                    list2Tmp.next = new ListNode(list1.val);
//                    list1 = list1.next;
//                } else {
//                    list2Tmp.next = new ListNode(list2.val);
//                    list2 = list2.next;
//                }
//            }
//
//            list2Tmp = list2Tmp.next;
//        }
//
//        return list1Tmp.next;
//    }