import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #146 - LRU Cache
 * Difficulty: Medium
 *
 * Problem:
 * Design a data structure that follows the Least Recently Used (LRU) eviction policy.
 * get(key)  -> value of the key if present, otherwise -1
 * put(key, value) -> insert or update the key. When the cache exceeds its capacity,
 *                   evict the least recently used key.
 *
 * Example 1:
 *   Input:  capacity = 2
 *           put(1,1), put(2,2), get(1) -> 1
 *           put(3,3)   // evicts key 2 (least recently used)
 *           get(2) -> -1
 *   Output: [1, -1]
 *
 * Example 2:
 *   Input:  capacity = 2
 *           put(1,1), put(2,2), get(2) -> 2
 *           put(4,4)   // evicts key 1
 *           get(1) -> -1, get(3) -> -1, put(3,3), get(4) -> 4
 *   Output: [-1, -1, 4]
 *
 * Approach: HashMap + Doubly Linked List
 * - The HashMap gives O(1) lookup from key -> list node.
 * - A doubly linked list maintains recency order: head side = most recently used,
 *   tail side = least recently used. O(1) removal requires both prev and next
 *   pointers, which is exactly why a singly linked list is not enough here.
 * - Every get() and put() on an existing key promotes that node to the front.
 * - On insert when full, the node just before the tail sentinel is evicted.
 *
 * Time Complexity : O(1) average per get / put
 * Space Complexity: O(capacity)
 */
public class LRU_Cache {

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, Node> cache;
    private final int capacity;
    // Sentinels: everything between them is a real entry.
    private final Node head;
    private final Node tail;

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Returns the value for the key, or -1 if the key is absent.
     * A hit marks the key as most recently used.
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToFront(node);
        return node.value;
    }

    /**
     * Inserts or updates the key. Evicts the least recently used key when full.
     */
    public void put(int key, int value) {
        Node existing = cache.get(key);
        if (existing != null) {
            existing.value = value;
            moveToFront(existing);
            return;
        }

        if (cache.size() >= capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void moveToFront(Node node) {
        if (head.next == node) {
            return;
        }
        remove(node);
        addToFront(node);
    }

    // Helper method to render cache contents from most to least recently used
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Node curr = head.next; curr != tail; curr = curr.next) {
            sb.append(curr.key).append("=").append(curr.value);
            if (curr.next != tail) {
                sb.append(", ");
            }
        }
        return sb.append("}").toString();
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        LRU_Cache cache = new LRU_Cache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("After put(1,1), put(2,2) : " + cache);
        System.out.println("get(1)                    : " + cache.get(1) + "  -> " + cache);

        cache.put(3, 3);
        System.out.println("After put(3,3) (evicts 2)  : " + cache);
        System.out.println("get(2)                    : " + cache.get(2));

        System.out.println();

        LRU_Cache cache2 = new LRU_Cache(2);
        cache2.put(1, 1);
        cache2.put(2, 2);
        System.out.println("get(2)                    : " + cache2.get(2));
        cache2.put(4, 4);
        System.out.println("After put(4,4) (evicts 1)  : " + cache2);
        System.out.println("get(1)                    : " + cache2.get(1));
        System.out.println("get(3)                    : " + cache2.get(3));
        cache2.put(3, 3);
        System.out.println("After put(3,3)            : " + cache2);
        System.out.println("get(4)                    : " + cache2.get(4));
    }
}
