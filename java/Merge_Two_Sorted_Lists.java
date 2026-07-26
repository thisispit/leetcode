/**
 * LC #21 - Merge Two Sorted Lists
 *
 * Problem:
 *   You are given the heads of two sorted linked lists list1 and list2.
 *   Merge the two lists into one sorted list. The list should be made by
 *   splicing together the nodes of the first two lists.
 *   Return the head of the merged linked list.
 *
 * Example:
 *   Input : list1 = [1,2,4], list2 = [1,3,4]
 *   Output: [1,1,2,3,4,4]
 *
 * Approach — Iterative with a dummy head:
 *   Use a dummy sentinel node so we never need a special case for the head.
 *   Walk both lists simultaneously, always appending the smaller node to the
 *   result. When one list is exhausted, append the remaining nodes of the other.
 *
 * Complexity:
 *   Time  : O(m + n) — each node is visited at most once.
 *   Space : O(1)     — no extra data structures; nodes are re-linked in place.
 */
public class Merge_Two_Sorted_Lists {

    // Definition for singly-linked list node.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Merges two sorted linked lists into one sorted linked list.
     *
     * @param list1 head of the first sorted linked list
     * @param list2 head of the second sorted linked list
     * @return head of the merged sorted linked list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy sentinel node — its next will be the real head of the result
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes (at most one list is non-null here)
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    // ── Helper to build and print a linked list ───────────────────────────────
    private static ListNode buildList(int... vals) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        for (ListNode n = head; n != null; n = n.next) {
            sb.append(n.val);
            if (n.next != null) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        Merge_Two_Sorted_Lists sol = new Merge_Two_Sorted_Lists();

        // Test 1: [1,2,4] + [1,3,4] → [1,1,2,3,4,4]
        ListNode merged1 = sol.mergeTwoLists(buildList(1, 2, 4), buildList(1, 3, 4));
        System.out.print("Test 1: ");
        printList(merged1); // [1, 1, 2, 3, 4, 4]

        // Test 2: [] + [] → []
        ListNode merged2 = sol.mergeTwoLists(null, null);
        System.out.print("Test 2: ");
        printList(merged2); // []

        // Test 3: [] + [0] → [0]
        ListNode merged3 = sol.mergeTwoLists(null, buildList(0));
        System.out.print("Test 3: ");
        printList(merged3); // [0]
    }
}
