import edu.princeton.cs.algs4.*;
import util.ArrayUtil;

public class MedianFinder<Key extends Comparable<Key>> {
  private Key[] maxHeap;
  private Key[] minHeap;
  private int N;

  public MedianFinder() {
  maxHeap = (Key[]) Comparable[2];
  minHeap = (Key[]) Comparable[2];
  }

  private boolean less(Key[] arr, int i, int j) {
    return arr[i].compareTo(arr[j])<0;
  }

  private boolean more(Key[] arr, int i, int j) {
    return arr[i].compareTo(arr[j])>=0;
  }



  private void maxHeapify(Key[] arr) {
    for (int k = N/2; k>=1; k--) {
      sink(arr,k)
    }
  }

  public void swimMin(int k) {
    while (k > 1 && ArrayUtil.more(k/2, k)) {
      exch(k/2, k);
      k = k/2;
    }
  }

  private void swimMax(int k) {
    while (k > 1 && ArrayUtil.less(k/2, k)) {
      exch(k/2, k);
      k = k/2;
    }
  }

  private void exch(Key[] arr,int i, int j) {
      Key swap = arr[i];
      arr[i] = arr[j];
      arr[j] = swap;
  }

  private void sink(Key[] arr, int k) {
    while (2*k <= N) {
      int j = 2*k;
      if (j < N && less(arr,j, j+1)) j++;
      if (!less(arr,k, j)) break;
      exch(arr,k, j);
      k = j;
    }
  }


  public Key findMedian() {
    return null;
  }

  public Key deleteMedian() {
    return null;
  }

  public void insert(Key key) {
  }

  public static void main(String[] args) {
    MedianFinder<String> m = new MedianFinder<String>();
    m.insert("1");
    m.insert("2");
    m.insert("3");
    m.insert("4");
    m.insert("5");
    m.insert("6");
    StdOut.println(m.findMedian());

  }
}
