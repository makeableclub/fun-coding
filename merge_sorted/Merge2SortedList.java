// maintain a temp pointer of "p"

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode p = head;

    while(l1!=null||l2!=null){
        if(l1!=null&&l2!=null){
            if(l1.val < l2.val){
                p.next = l1;
                l1=l1.next;
            }
            else{
                p.next=l2;
                l2=l2.next;
            }
            // each time, either l1, or l2 move forward, and merged list points to "p"
            p = p.next;
        }
        else if(l1==null){
            p.next = l2;
            break;
        }
        else if(l2==null){
            p.next = l1;
            break;
        }
    }

    return head.next;
}


// Method 2:
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode p=head;

    ListNode p1=l1;
    ListNode p2=l2;
    while(p1!=null && p2!=null){
        if(p1.val < p2.val){
            p.next = p1;
            p1 = p1.next;
        }else{
            p.next = p2;
            p2 = p2.next;
        }
        p=p.next;
    }

    if(p1!=null){
        p.next = p1;
    }

    if(p2!=null){
        p.next = p2;
    }

    return head.next;
}
