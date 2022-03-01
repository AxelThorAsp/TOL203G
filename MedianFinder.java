import edu.princeton.cs.algs4.*;
import java.util.Arrays;

class MaxHeap<Key>  {
  public Key[] q;     // index starts at 1
  private int n = 0;       // items in heap

  public MaxHeap() {
    q = (Key[]) new Object[2];
  }

  public boolean isEmpty() {
        return n == 0;
    }

  public int size() {
    return this.n;
  }

  public Key peek() {
    return q[1];
  }

  public Key max() {

    return q[1];
  }

  private void resize(int capacity) {
    assert capacity > n;
    Key[] temp = (Key[]) new Object[capacity];
    for (int i = 1; i <= n; i++) {
      temp[i] = q[i];
    }
    q = temp;
  }
  public void insert(Key x) {
    // double size of array if necessary
    if (n == q.length - 1) resize(2 * q.length);
    // add x, and percolate it up to maintain heap invariant
    q[++n] = x;
    swim(n);
  }

  public Key delMax() {
    Key max = q[1];
    exch(1, n--);
    sink(1);
    q[n+1] = null;     // to avoid loitering and help with garbage collection
    if ((n > 0) && (n == (q.length - 1) / 4)) resize(q.length / 2);
    return max;
  }

  private void swim(int k) {
    while (k > 1 && less(k/2, k)) {
    exch(k/2, k);
    k = k/2;
    }
  }

  private void sink(int k) {
    while (2*k <= n) {
      int j = 2*k;
      if (j < n && less(j, j+1)) j++;
      if (!less(k, j)) break;
      exch(k, j);
      k = j;
    }
  }

  private boolean less(int i, int j) {
    return ((Comparable<Key>) q[i]).compareTo(q[j]) < 0;
  }

  private void exch(int i, int j) {
    Key swap = q[i];
    q[i] = q[j];
    q[j] = swap;
  }

};

class MinHeap<Key> {
  public Key[] q;     // index starts at 1
  private int n = 0;       // items in heap

  public MinHeap(){
    q = (Key[]) new Object[2];
  }

  public boolean isEmpty() {
        return n == 0;
  }

  public Key peek() {
    return q[1];
  }

  public int size() {
    return n;
  }

  public Key max() {
    return q[1];
  }

  private void resize(int capacity) {
    assert capacity > n;
    Key[] temp = (Key[]) new Object[capacity];
    for (int i = 1; i <= n; i++) {
      temp[i] = q[i];
    }
    q = temp;
  }
  public void insert(Key x) {
    // double size of array if necessary
    if (n == q.length - 1) resize(2 * q.length);
    // add x, and percolate it up to maintain heap invariant
    q[++n] = x;
    swim(n);
  }

  public Key delMax() {
    Key max = q[1];
    exch(1, n--);
    sink(1);
    q[n+1] = null;     // to avoid loitering and help with garbage collection
    if ((n > 0) && (n == (q.length - 1) / 4)) resize(q.length / 2);
    return max;
  }

  private void swim(int k) {
    while (k > 1 && greater(k/2, k)) {
    exch(k/2, k);
    k = k/2;
    }
  }

  private void sink(int k) {
    while (2*k <= n) {
      int j = 2*k;
      if (j < n && greater(j, j+1)) j++;
      if (!greater(k, j)) break;
      exch(k, j);
      k = j;
    }
  }

  private boolean greater(int i, int j) {
    return ((Comparable<Key>) q[i]).compareTo(q[j]) > 0;
  }

  private void exch(int i, int j) {
    Key swap = q[i];
    q[i] = q[j];
    q[j] = swap;
  }

}


public class MedianFinder<Key extends Comparable<Key>> {
  private MaxHeap<Key> maxHp;
  private MinHeap<Key> minHp;

  private int size;

  public MedianFinder() {
     maxHp = new MaxHeap<Key>();
     minHp = new MinHeap<Key>();
     size = 0;
  }
  public Key findMedian() {
    Key median;

    if (minHp.size() > maxHp.size()) {
      median = minHp.peek();
    }
    else {
      median = maxHp.peek();
    }

    return median;
  }


  public Key deleteMedian() {
    if (size==0) {
      return null;
    }
    Key median;

    if (minHp.size() > maxHp.size()) {
      median = minHp.delMax();
    }
    else {
      median = maxHp.delMax();
    }

    size--;

    return median;
  }
  public void insert(Key key) {
    if (size == 0 || key.compareTo(maxHp.peek()) < 0) {
      maxHp.insert(key);
  }
  else {
    minHp.insert(key);
  }

  if (minHp.size() > maxHp.size() + 1) {
      Key move = minHp.delMax();
      maxHp.insert(move);
  }
  else if (maxHp.size() > minHp.size() + 1) {
      Key move = maxHp.delMax();
      minHp.insert(move);
  }

  size++;
  }



  public static void main(String[] args) {
     MinHeap<String> minh = new MinHeap<String>();
     MaxHeap<String> maxh = new MaxHeap<String>();
     minh.insert("E");
     minh.insert("A");
     minh.insert("B");
     minh.insert("C");
     minh.insert("D");

     maxh.insert("E");
     maxh.insert("A");
     maxh.insert("B");
     maxh.insert("C");
     maxh.insert("D");

     System.out.println(maxh.peek());
     System.out.println(minh.peek());

  }
}
