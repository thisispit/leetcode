/**
 * LeetCode #141 - Linked List Cycle
 * Difficulty: Easy
 *
 * Problem:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer. Return true if there is a cycle,
 * otherwise return false.
 *
 * Approach: Floyd's Cycle Detection (Two Pointers / Fast & Slow)
 * - Use two pointers: slow moves one step at a time, fast moves two steps.
 * - If there is a cycle, fast will eventually catch up to slow (they meet).
 * - If there is no cycle, fast will reach null.
 *
 * Time Complexity:  O(n) — each node is visited at most twice
 * Space Complexity: O(1) — no extra data structures used
 */
public class Linked_List_Cycle {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Detects if a linked list contains a cycle using Floyd's algorithm.
     *
     * @param head the head node of the linked list
     * @return true if a cycle exists, false otherwise
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) return true; // cycle detected
        }

        return false; // fast reached end — no cycle
    }

    // ---------------------------------------------------------------
    // Driver / Test
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        Linked_List_Cycle sol = new Linked_List_Cycle();

        // Test 1: [3 -> 2 -> 0 -> -4] with cycle at index 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // cycle back to node with val=2
        System.out.println("Test 1 (expected true):  " + sol.hasCycle(head1));

        // Test 2: [1 -> 2] with cycle at index 0
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // cycle back to head
        System.out.println("Test 2 (expected true):  " + sol.hasCycle(head2));

        // Test 3: [1] no cycle
        ListNode head3 = new ListNode(1);
        System.out.println("Test 3 (expected false): " + sol.hasCycle(head3));

        // Test 4: null input
        System.out.println("Test 4 (expected false): " + sol.hasCycle(null));
    }
}
