package MaiJavaTools.DataStructure;

import java.util.HashMap;

public class LinkedListDeepCopy {
    /**
     * Definition for singly-linked list with a random pointer.
     */

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        HashMap<RandomListNode, RandomListNode> visited = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        visited.put(head, newHead);
        deepCopyNode(head, newHead, visited);
        return newHead;
    }

    public void deepCopyNode(RandomListNode source, RandomListNode clone, HashMap<RandomListNode, RandomListNode> visited) {

        if (source == null)
            return;

        if (visited.containsKey(source)) {
            clone = visited.get(source);
        } else {
            clone = new RandomListNode(source.label);
            visited.put(source, clone);
        }


        if (source.next != null && clone.next == null /* && !visited.contains(source.next) */) {
            clone.next = new RandomListNode(source.next.label);
        }
        if (source.random != null && clone.random == null /*&& !visited.contains(source.random)*/)
            clone.random = new RandomListNode(source.random.label);

        deepCopyNode(source.next, clone.next, visited);
        deepCopyNode(source.random, clone.random, visited);
        return;
    }

}
