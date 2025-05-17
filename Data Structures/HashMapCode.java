import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K, V>{ //generics
        // create a node class
        public class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        //create the required variables
        private int n; // Total Number of Nodes
        private int N; // Total number of Buckets ie. array size
        private LinkedList<Node>[] buckets; // N = buckets.length

        // Initialize the hashmap
        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<buckets.length; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        // Hash Function
        public int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        // Search in the LL (we have the bucket index or bi)
        public int searchInBucket(K key, int bi){
            LinkedList<Node> ll = buckets[bi];

            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key.equals(key)){
                    return i; //data index or di
                }
            }

            return -1;
        }

        // rehash
        @SuppressWarnings("unchecked")
        public void rehash() {
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N*2];
            N = N * 2;  // Update N
            for(int i=0; i<N; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBuckets.length; i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        // Put Method
        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchInBucket(key, bi);

            if(di == -1){
                buckets[bi].add(new Node(key, value));
                n++;
            }
            else{
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            // calculate lambda in case of rehash needed
            double lambda = (double)n/N;

            if(lambda > 2.0){
                rehash();
            }
        }

        // ContainsKey Method
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInBucket(key, bi); //di = -1
            if(di == -1) { //key doesn't exist
                return false;
            } else { //key exists
                return true;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInBucket(key, bi); //di = -1
            if(di == -1) { //key doesn't exist
                return null;
            } else { //key exists
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInBucket(key, bi); //di = -1
            if(di == -1) { //key doesn't exist
                return null;
            } else { //key exists
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++) { //bi
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++) { //di
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    // get element at ith index (Additional Method)

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);
        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++) {
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }

        map.remove("India");
        System.out.println(map.get("India"));
    }
}