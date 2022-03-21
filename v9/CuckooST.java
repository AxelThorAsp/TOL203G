import edu.princeton.cs.algs4.*;

public class CuckooST<Key, Value> {
  private static final int INIT_CAPACITY = 16;

  private int n;           // number of key-value pairs in the symbol table
  private int m;           // size of the tables
  private Key[][] keys;      // the keys
  private Value[][] vals;    // the values
  private Random rand = new Random();


  // taken from MurmurHash3 http://sites.google.com/site/murmurhash/
  // and http://facebook.github.io/jcommon/util/jacoco/com.facebook.util.digest/MurmurHash.java.html

  private long rotateLeft64(long x, int r) {
    return (x << r) | (x >>> (64 - r));
  }

  private long fmix(long k) {
    k ^= k >>> 33;
    k *= 0xff51afd7ed558ccdL;
    k ^= k >>> 33;
    k *= 0xc4ceb9fe1a85ec53L;
    k ^= k >>> 33;
    return k;
  }

  public long murmurhash(long data, long seed) {
    long c1 = 0x87c37b91114253d5L;
    long c2 = 0x4cf5ad432745937fL;

    long h1 = seed, h2 = seed;

    long k1 = data;
    k1 *= c1;
    k1 = rotateLeft64(k1, 31);
    k1 *= c2;
    h1 ^= k1;

    h1 ^= 8;
    h2 ^= 8;

    h1 += h2;
    h2 += h1;

    return (fmix(h1) + fmix(h2));
  }

  public CuckooST() {
    this(INIT_CAPACITY);
  }

  public CuckooST(int capacity) {
    m = capacity;
    n = 0;
    keys = (Key[][]) new Object[2][];
    keys[0] = (Key[]) new Object[m];
    keys[1] = (Key[]) new Object[m];

    vals = (Value[][]) new Object[2][];
    vals[0] = (Value[]) new Object[m];
    vals[1] = (Value[]) new Object[m];
  }

  public int size() {
    return n;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public boolean contains(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to contains() is null");
    return get(key) != null;
  }


  private void resize(int capacity) {
    CuckooST<Key, Value> temp = new CuckooST<Key, Value>(capacity);
    for (int i = 0; i < m; i++) {
      if (keys[0][i] != null) {
        temp.put(keys[0][i], vals[0][i]);
      }
      if (keys[1][i] != null) {
        temp.put(keys[1][i], vals[1][i]);
      }
    }
    keys = temp.keys;
    vals = temp.vals;
    m    = temp.m;
  }


  private int hash(Key key, int index) {
    long h = murmurhash(key.hashCode(), 42);
    int h1 = ((int)(h & 0x7fffffff)) % m;
    int h2 = ((int)((h >> 32) & 0x7fffffff)) % m;
    int[] hs = {h1, h2};
    return hs[index];
  }

  public void put(Key key, Value val) {
    int count = 0;
    if (key == null) throw new IllegalArgumentException("first argument to put() is null");
    long h = murmurhash(key.hashCode(), 42);
    int h1 = ((int)(h & 0x7fffffff)) % m;
    int h2 = ((int)((h >> 32) & 0x7fffffff)) % m;
    int[] hs = {h1, h2};

    if (val == null) {
      //delete(key);
      return;
    }

    if (n > (0.5*m)) {
      resize(2*m);
    }

    if (keys[0][h1] = null) {
      keys[0][h1] = key;
      vals[0][h1] = val;
      n++;
    }
    else {
      Key inTo = keys[0][h1];
      while(inTo != null){
        int h = hash(inTo, count % 2);
        Key tempKey = keys[count % 2][h];
        Value tempVal = vals[count % 2][h]];

        keys[count % 2][hash(key, count % 2)] = key;
        vals[count % 2][hash(key, count % 2)] = val;

        ++count;
        int H = hash(tempKey, count % 2);
        inTo = keys[count % 2][H];

        keys[count % 2][H] = tempKey;
        vals[count % 2][H] = tempVal;

        key = tempKey;
        val = tempVal;

        if (count >100){
          //max depth
          resize(m + 1);
          put(key, val);
        }
      }
    }
  }

  public Value get(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to get() is null");
    long h = murmurhash(key.hashCode(), 42);
    int h1 = ((int)(h & 0x7fffffff)) % m;
    int h2 = ((int)((h >> 32) & 0x7fffffff)) % m;

    if (keys[0][h1].equals(key)) {
      return keys[0][h1];
    }
    else if (keys[1][h2].equals(key)){
      return keys[1][h2];
    }
    else {
      System.out.println("ERROR: no such key exists.");
    }
  }

  public Iterable<Key> keys() {
    Queue<Key> queue = new Queue<Key>();
    for (int i = 0; i < m; i++) {
      if (keys[0][i] != null) queue.enqueue(keys[0][i]);
      if (keys[1][i] != null) queue.enqueue(keys[1][i]);
    }
    return queue;
  }


  public static void main(String[] args) {
    CuckooST<Integer, Integer> st = new CuckooST<Integer, Integer>();
    for (int i = 0; i < 100; i++) {
      st.put(i, i*i);
    }

    // print keys
    for (Integer i : st.keys()) {
      StdOut.println(i + " " + st.get(i));
    }
    for (int i = 0; i < 100; i++) {
      if (!st.contains(i)) {
        System.out.println("Error: Key not found " + i );
      }
      Integer j = st.get(i);
      if (!j.equals(i*i)) {
        System.out.println("Error: Key found = " + i + ", wrong value " + j );
      }

    }
  }
}
