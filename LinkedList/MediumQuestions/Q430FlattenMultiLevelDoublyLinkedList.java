package LinkedList.MediumQuestions;

import java.util.ArrayDeque;
import java.util.Deque;

/*
You are given a doubly linked list, which contains nodes that have a next pointer, a previous 
pointer, and an additional child pointer. This child pointer may or may not point to a separate 
doubly linked list, also containing these special nodes. These child lists may have one or more 
children of their own, and so on, to produce a multilevel data structure as shown in the example 
below.
Given the head of the first level of the list, flatten the list so that all the nodes appear in a 
single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child 
list should appear after curr and before curr.next in the flattened list.
Return the head of the flattened list. The nodes in the list must have all of their child pointers 
set to null.

Example 1:
Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]

Example 2:
Input: head = [1,2,null,3]
Output: [1,3,2]
*/

public class Q430FlattenMultiLevelDoublyLinkedList {

    public Node flatten(Node head) {

        // iteratively
        if (head == null)
            return head;

        Node dummy = new Node(0, null, head, null);
        Node curr, prev = dummy;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) 
        {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null)
                stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        dummy.next.prev = null;
        return dummy.next;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val, Node prev, Node next, Node child){
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }
}