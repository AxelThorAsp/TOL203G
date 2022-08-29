import edu.princeton.cs.algs4.*;

public class STtest<Key, Value> {
    private int n;
    private int m;
    private int k;
    private Key[] keys1, keys2;
    private Value[] vals1, vals2;

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    

    public STtest(int capacity, int limit) {
        k = limit;
        m = capacity;
        n = 0;
        keys1 = (Key[]) new Object[m];
        keys2 = (Key[]) new Object[m];
        vals1 = (Value[]) new Object[m];
        vals2 = (Value[]) new Object[m];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    public Value get(Key key) {
        int count = 0;
        for(int i = hash(key); keys1[i]!= null; i=(i+1) % m) {
            if(keys1[i].equals(key)) return vals1[i];
            if(count == k) break;
            count++;
        }
        for(int i = hash(key); keys2[i] != null; i=(i+1) % m) {
            if(keys2[i].equals(key)) return vals2[i];
        }
        return null;
    }
    public void put(Key key, Value val) {
        int i;
        int count = 0;
        for(i = hash(key); keys1[i] != null; i=(i+1) % m) {
            if (count == k) break;
            count++;
            if(keys1[i].equals(key)) {
                vals1[i] = val;
                return;
            }
        }
        if (count == k){
            for(i = hash(key); keys2[i] != null; i=(i+1) % m) {
                if(keys2[i].equals(key)) {
                    vals2[i] = val;
                    return;
                }
            }
            keys2[i] = key;
            vals2[i] = val;
        }
        else{
            keys1[i] = key;
            vals1[i] = val;
            return;
        }

    }

    public static void main(String[] args) {

    }
}