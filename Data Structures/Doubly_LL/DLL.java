// package Doubly_LL;

import java.util.ArrayList;
import java.util.List;

public class DLL {
    // Node
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
        }
    }

    // Global Variables
    private Node head;
    private Node tail;
    private int size;

    // Initialization
    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add First
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add Last
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Remove at Position
    public int removeAtPos(int idx){
        if(head == null || idx < 0 || idx >= size){
            return -1;
        }

        Node temp = head;
        while (temp != null && idx > 0) {
            temp = temp.next;
            idx--;
        }

        int val = temp.data;

        if(temp == head){
            head = head.next;
            if(head != null) head.prev = null;
            else tail = null;
        }
        else if(temp == tail){
            tail = tail.prev;
            if(tail != null) tail.next = null;
        }
        else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        size--;

        return val;
    }

    // Add at Position
    public void addAtPos(int pos, int data){
        Node newNode = new Node(data);
        if(pos < 0 || pos > size) return;

        if(head == null){
            head = tail = newNode;
        }
        if(pos == 0){
            this.addFirst(data);
            return;
        }
        else if(pos == size){
            this.addLast(data);
            return;
        }

        Node temp = head;
        while (temp != null && pos > 1) {
            temp = temp.next;
            pos--;
        }

        size++;

        Node nextNode = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }

    // Reverse
    public void reverse() {
        Node curr = head;
        Node temp = null;

        while (curr != null) {
            temp = curr.prev; // store previous
            curr.prev = curr.next; // connect prev to next
            curr.next = temp; // connect next to prev
            curr = curr.prev; // move one step ahead (since next and prev are swapped)
        }

        if(temp != null) head = temp.prev;
    }

    // Print
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Delete All Occurances of a number
    public void deleteAllOccurances(int val){
        if(head == null) return;

        Node temp = head;
        while(temp != null){
            if(temp.data == val){
                Node nextNode = temp.next;
                // Edge Cases
                if(temp.prev == null){
                    head = head.next;
                    if(head != null) head.prev = null;
                    else tail = null;
                } 
                else if(temp.next == null) {
                    tail = tail.prev;
                    if(tail.next != null) tail.next = null;
                    else head = null;
                }
                else{
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                size--;
                temp = nextNode;
            }
            else{
                temp = temp.next;
            }
        }
    }

    // Find Pairs equal to sum in Sorted LL
    public void findPairs(int sum){
        List<List<Integer>> res = new ArrayList<>();
        Node left = head, right = tail;

        while(left != null && right != null && left != right && right.next != left){
            List<Integer> list = new ArrayList<>();
            int curr = left.data + right.data;
            if(curr == sum){
                list.add(left.data);
                list.add(right.data);
                res.add(list);
                left = left.next;
                right = right.prev;
            }
            else if(curr > sum){
                right = right.prev;
            }
            else{
                left = left.next;
            }
        }

        System.out.println(res);
    }

    // Remove Duplicates from Sorted LL
    public void removeDuplicates(){
        if(head == null || head.next == null) return;
        Node temp = head;

        while (temp != null && temp.next != null) {
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.addFirst(0);
        dll.addLast(6);
        dll.print();
        dll.removeDuplicates();
        dll.print();
    }
}
