import java.util.*;

class Binary_Tree {
    public static class Node{
        int data;
        Node left, right;
        public Node(int item){
            data = item;
            left = right = null;
        }
    }

    // Root Left Right
    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Initially push root in stack
    // Use a Stack Print the curr Node.data Push Right first then left while stack is not empty
    public static void preorderItr(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);
        ArrayList<Integer> nums = new ArrayList<>();

        while (!st.isEmpty()) {
            Node node = st.pop();
            nums.add(node.data);

            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }

        for(int i=0; i<nums.size(); i++){
            System.out.print(nums.get(i) + " ");
        }
    }

    // Left Root Right
    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Do not initially push root in stack
    // if a node is not null then push it in stack got to as left as possible
    // if a node is null then get the top node of stack print it and go to its right if the stack is not empty
    public static void inorderItr(Node root){
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node node = root;

        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                list.add(node.data);
                node = node.right;
            }
        }

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    // Left Right Root
    public static void postorder(Node root){
        if(root == null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Using 2 Stacks
    // Initially push root in stack1
    // Pop the stack1 top and push it in stack2
    // If Left exists push it in stack1, same for right
    // pop all nodes from stack2 add it in result
    public static void postorderItr1(Node root){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        st1.push(root);

        while(!st1.isEmpty()){
            Node node = st1.pop();
            st2.push(node);

            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }

        while(!st2.isEmpty()){
            list.add(st2.pop().data);
        }

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    // Add the root in Queue
    // Get the first element in res
    // if left exist then add it in queue, same for right
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // preorder(root);
        // inorder(root);
        // postorder(root);
        // levelOrder(root);
        // preorderItr(root);
        // inorderItr(root);
        postorderItr1(root);
    }
}