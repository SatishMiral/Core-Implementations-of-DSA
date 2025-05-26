package Doubly_LL;
public class DoublyLL {
    public static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void removeAtPos(int pos){
        if (head == null || pos < 0 || pos >= size) return;

        Node temp = head;
        while (temp != null && pos > 0){
            temp = temp.next;
            pos--;
        }

        if (temp == null) return;

        if (temp == head){
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null; // If list becomes empty
        }
        else if (temp == tail){
            tail = tail.prev;
            if (tail != null) tail.next = null;
        }
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        size--;
    }


    public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addFirst(5);
        System.out.println(dll.size);
        dll.print();
        dll.removeAtPos(4);
        dll.print();
    }
}