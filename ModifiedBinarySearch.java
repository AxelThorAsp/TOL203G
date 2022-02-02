
import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class ModifiedBinarySearch {
  public static int indexOf(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
        // Key is in a[lo..hi] or not present.
        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) hi = mid - 1;
        else if (key > a[mid]) lo = mid + 1;
        else if (mid>0 && key==a[mid-1]) {
          hi=mid-1;
        }
        else return mid;
    }

    return -1;
}

    public static void main(String[] args) {

        In in = new In(args[0]);
        int[] allowlist = in.readAllInts();
        Arrays.sort(allowlist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.println(BinarySearch.indexOf(allowlist, key));
        }
    }
}
