import edu.princeton.cs.algs4.*;
import java.util.Arrays;
public class Triplicate {
  public static String triplicate( String[] a, String[] b, String[] c) {
    Merge.sort(a); // N logN
    Merge.sort(b);
    Merge.sort(c);
    int i=0;
    int j=0;
    int k=0;
    while (i < a.length && j < b.length && k < c.length) {
      if (a[i].compareTo(b[j])>0 && a[i].compareTo(c[k])>0) {
        j++;
        k++;
      }
      else if (b[j].compareTo(a[i])>0 && b[j].compareTo(c[k])>0) {
        i++;
        k++;
      }
      else if (c[k].compareTo(a[i])>0 && c[k].compareTo(b[j])>0) {
        j++;
        i++;
      }
      else if (a[i].compareTo(b[j])>0) {
        j++;
      }
      else if (a[i].compareTo(c[k])>0) {
        k++;
      }
      else if (b[j].compareTo(a[i])>0) {
        i++;
      }
      else if (b[j].compareTo(c[k])>0) {
        k++;
      }
      else if (c[k].compareTo(a[i])>0) {
        i++;
      }
      else if (c[k].compareTo(b[j])>0) {
        j++;
      }
      else {
        return a[i];
      }

    }

    return "";

  }
  public static void main(String[] args) {
    String[] a ={"a","c","b"};
    String[] b ={"b","c","d"};
    String[] c ={"e","f","b"};
    StdOut.println(triplicate(a,b,c));
  }
}
