package Stack;
public class Stack_Array {
    public static class Stack{
        private int[] arr;
        private int top;
        private int capacity;

        public Stack(){
            this.capacity = 4;
            this.arr = new int[capacity];
            this.top = -1;
        }

        private void resize(){
            int newCap = capacity * 2;
            int[] newArr = new int[newCap];

            for(int i=0; i<capacity; i++){
                newArr[i] = arr[i];
            }

            arr = newArr;
            capacity = newCap;
        }

        public Boolean isEmpty(){
            return top == -1;
        }

        public void push(int data){
            if(top == capacity - 1){
                resize();
            }

            arr[++top] = data;
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("Underflow");
            }

            return arr[top--];
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Underflow");
            }

            return arr[top];
        }

        public int size(){
            return top + 1;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(s.size() != 0){
            System.out.print(s.pop() + " ");
        }
    }
}
