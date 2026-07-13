from numbers import Integral


public int singleNumber(List<Integer>A){
    int temp=0;
    for(int i=0;i<A.size();;i++){
        temp=temp^A[i];
    }
    return temp;
}


//
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode tail = head;
        int length=1;
        while(tail.next!=null){ // Finds the tail and the length of the provided linked list
            tail=tail.next;
            length++;
        }
        tail.next = head; // Making it a circular linked list.

        int stepRotate = length-(k%length); // Number of steps to move in the list

        for(int i=0;i<stepRotate;i++){
            head=head.next;
            tail=tail.next;
        }
        tail.next=null;

        return head;
    }
}
