// package LinkedList;
public class LinkedList {
    // Create a Node class to store data and reference to next element(Node)
    // It’s static because we don’t need a LinkedList object to create a Node. 
    // (It doesn't depend on any outer instance.) Its just like a simple data holder
    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Why Private? -> We are encapsulating the inner structure. 
    // Outside classes shouldn’t mess with internals of the linked list directly.
    private Node head;
    private Node tail;
    private int size;

    // Initializes a fresh LinkedList with no elements.
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add to front
    public void addFirst(int data){
        size++;
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add to Last
    public void addLast(int data){
        size++;
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Print the List
    public void print(){
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Add at Index
    public void addAtIndex(int index, int data){
        if(index == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        //reach an index before
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove from Front
    public int removeFirst(){
        if(head == null) return -1;
        size--;
        int val = head.data;
        if(size == 0){
            head = tail = null;
        }
        else{
            head = head.next;
        }
        return val;
    }

    // Remove from Last
    public int removeLast(){
        if(head == null) return -1;

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    // Reverse the LL
    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;
        tail = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find Mid Node
    public Node findMid(){
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Dutch National Flag Algorithm (Sort 0s, 1s and 2s)
    public void dutchFlag(){
        if(head == null || head.next == null) return;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;

        while (temp != null) {
            if(temp.data == 0){
                zero.next = temp;
                zero = temp;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = temp;
            }
            else{
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        if(one.next != null) zero.next = oneHead.next;
        one.next = twoHead.next;
        two.next = null;

        head = zeroHead.next;
    }

    // Add one to a Number represented by LL
    public void addOne(){
        int carry = 1;
        this.reverse();

        Node temp = head;
        while(temp != null){
            temp.data += carry;

            if(temp.data < 10){
                carry = 0;
                break;
            }

            temp.data = 0;
            carry = 1;
            temp = temp.next;
        }

        this.reverse();

        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
    }

    // For testing
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(9);
        ll.addFirst(9);
        ll.addFirst(9);
        ll.print();
        ll.addOne();
        ll.print();
    }
}
