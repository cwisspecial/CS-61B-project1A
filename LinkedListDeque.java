public class LinkedListDeque<LochNess> {

    public class ListNode {
        private LochNess item;
        private ListNode first;
        private ListNode next;


        public ListNode(LochNess x, ListNode f, ListNode n) {
            item = x;
            first = f;
            next = n;

        }
    }

    private ListNode guardFirst;
    private ListNode guardLast;
    private int size = 0;

    public LinkedListDeque() {
        guardFirst = new ListNode(null,null,null);
        guardLast = new ListNode(null,null,null);
        guardFirst.next = guardLast;
        guardFirst.first = guardLast;
        guardLast.first = guardFirst;
        guardLast.next = guardFirst;
    }


    public void addFirst(LochNess x) {
        ListNode p = new ListNode(x,guardFirst,guardFirst.next);
        guardFirst.next = p;
        p.next.first = p;
        size += 1;
    }


    public void addLast(LochNess x) {
        ListNode p = new ListNode(x,guardLast.first,guardLast);
        guardLast.first = p;
        p.first.next = p;
        p.first.next = p;
        size += 1;
    }

    public boolean isEmpty() {
        if(guardFirst.next == guardLast) {
            return true;
        }
        else{
            return false;
        }

    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(int i = 0;i < size; i++) {
            if(guardFirst.next != guardLast) {
                System.out.println(guardFirst.next.item);
                System.out.println(" ");
                guardFirst = guardFirst.next;
            }
            else {
                System.out.println(guardFirst.next.item);
                System.out.println(" ");
            }
        }
    }
    ///????///


    //迭代法
    public LochNess get(int x) {
        int i = 0;
        LochNess temp = guardFirst.next.item;
        if(guardFirst.next == guardLast) {
            while (i < x) {
                guardFirst = guardFirst.next.next;
                i += 1;
                temp = guardFirst.item;
            }
        }
        else {
            return null;
             }
        return temp;
    }

    public LochNess removeFirst() {
        ListNode p = guardFirst.next;
        if(p != guardLast) {
            guardFirst.next = p.next;
            p.next.first = guardFirst;
            return p.item;
        }
        return null;
    }

    //递归法
    public LochNess getRecursive(int x) {
        int sum = 0;
        if(guardFirst.next == guardLast) {
            return null;
        }
        if(sum == x) {
            return get(x);
        }
        else {
            sum += 1;
            getRecursive(sum);
        }



        return null;
    }
}
