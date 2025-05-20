public class Stack_LL {
    // Creating a Node class to make a LL
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Creating a stack class to implement stack
    public static class Stack{
        // Required variables
        private Node head;
        private int size;

        // Initializing the stack
        public Stack(){
            this.head = null;
            this.size = 0;
        }

        // Check if stack is empty
        public boolean isEmpty(){
            return head == null;
        }

        // Push Op
        public void push(int data){
            Node newNode = new Node(data);
            size++;

            if(isEmpty()){
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        // Pop op
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            size--;

            int val = head.data;
            head = head.next;
            return val;
        }

        // Peek op
        public int peek(){
            if(isEmpty()){
                return -1;
            }

            return head.data;
        }

        // Get Size
        public int size(){
            return size;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.peek());
        st.push(4);
        System.out.println(st.pop());
    }
}