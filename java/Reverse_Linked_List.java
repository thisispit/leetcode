/**
 * LeetCode #206 - Reverse Linked List
 * Difficulty: Easy
 *
 * Problem:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 *   Input:  head = [1,2,3,4,5]
 *   Output: [5,4,3,2,1]
 *
 * Example 2:
 *   Input:  head = [1,2]
 *   Output: [2,1]
 *
 * Example 3:
 *   Input:  head = []
 *   Output: []
 *
 * Approach 1: Iterative (Three Pointers - prev, curr, nextNode)
 * - Initialize prev = null, curr = head.
 * - Iterate through list: save curr.next, point curr.next to prev, advance prev and curr.
 * - Return prev as the new head.
 * Time Complexity : O(n) — single pass through the list
 * Space Complexity: O(1) — constant extra space
 *
 * Approach 2: Recursive
 * - Base case: if head is null or head.next is null, return head.
 * - Recursively reverse the rest of the list: newHead = reverseList(head.next).
 * - Make the next node point back to head: head.next.next = head.
 * - Set head.next = null to avoid cycles.
 * Time Complexity : O(n)
 * Space Complexity: O(n) — call stack recursion
 */
public class Reverse_Linked_List {

    // Definition for singly-linked list node.
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Reverses a singly-linked list iteratively.
     *
     * @param head the head of the list
     * @return the head of the reversed list
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    /**
     * Reverses a singly-linked list recursively.
     *
     * @param head the head of the list
     * @return the head of the reversed list
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // Helper method to convert an array into a linked list
    public static ListNode fromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper method to print the linked list
    public static String toListString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        Reverse_Linked_List sol = new Reverse_Linked_List();

        // Test 1: [1, 2, 3, 4, 5] -> [5, 4, 3, 2, 1]
        ListNode list1 = fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original 1 : " + toListString(list1));
        ListNode rev1 = sol.reverseList(list1);
        System.out.println("Reversed 1 : " + toListString(rev1));

        // Test 2 (Recursive): [1, 2] -> [2, 1]
        ListNode list2 = fromArray(new int[]{1, 2});
        System.out.println("Original 2 : " + toListString(list2));
        ListNode rev2 = sol.reverseListRecursive(list2);
        System.out.println("Reversed 2 : " + toListString(rev2));

        // Test 3: [] -> []
        ListNode list3 = fromArray(new int[]{});
        System.out.println("Original 3 : " + toListString(list3));
        ListNode rev3 = sol.reverseList(list3);
        System.out.println("Reversed 3 : " + toListString(rev3));
    }
}
