import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class CountReps {
  public static void main(String[] args) {
    int[] a = StdIn.readAllInts();
    Stopwatch s = new Stopwatch();
    int rep = countReps(a);
    double t = s.elapsedTime();
    StdOut.println("pairs: "+rep);
    StdOut.println(t);

  }
  public static int countReps(int[] a) {
    int count=0;
    int pairs=0;
    Arrays.sort(a);
    for (int i =0 ;i<a.length-1 ;i++ ) {
        if (a.length==1 || a.length==0) {
          return 0;}

        if (a[i]==a[i+1]) {count++;}
        else {
          int s=1;
          for (int j=1;j<=2;j++ ) {
            s=s*(count+1-(2-j))/j;
        }
        pairs=pairs+s;
        count=0;}
        if (i+2==a.length) {
          int s=1;
          for (int j=1;j<=2;j++ ) {
            s=s*(count+1-(2-j))/j;
          }
          pairs=pairs+s;
        }
    }

    return pairs;}
  }
