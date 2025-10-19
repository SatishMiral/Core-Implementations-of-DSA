public class LL {
    // Node
    private static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Global Variables
    // Not static because 
    // Static means shared across all instances.
    // So if you create 2 LinkedLists, they’ll share the same nodes — incorrect.
    private Node head;
    private Node tail;
    private int size;

    //Initialization
    public LL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add to front
    public void addFront(int data){
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

        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Add at Index
    public void addAtIndex(int idx, int data){
        if(idx < 0 || idx > size) return;

        if(idx == 0){
            addFront(data);
            return;
        } 
        if(idx == size){
            addLast(data);
            return;
        }

        size++;
        Node newNode = new Node(data);
        Node temp = head;

        for(int i = 0; i < idx-1; i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove from Front
    public int removeFirst() {
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
    public int removeLast() {
        if(head == null) return -1;

        size--;
        int val = tail.data;
        if(size == 0){
            head = tail = null;
        }
        else{
            Node temp = head;
            while(temp.next != tail) temp = temp.next;
            temp.next = null;
            tail = temp;
        }

        return val;
    }

    // Remove from Index
    public int removeFromIndex(int idx){
        if(head == null || idx < 0 || idx >= size) return -1;

        if(idx == 0) return removeFirst();
        if(idx == size - 1) return removeLast();

        size--;
        Node temp = head;
        for(int i = 0; i < idx - 1; i++){
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;

        return val;
    }

    // Search in the LL
    public int search(int data){
        if(head == null) return -1;

        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.data == data) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }

        return -1;
    }

    public static void main(String[] args) {
        LL ll = new LL();
        ll.addFront(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        System.out.println(ll.search(5));
    }
}