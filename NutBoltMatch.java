
public class NutBoltMatch {
  public static void match(Nut[] a, Bolt[] b) {
    int l = 0;
    int r = a.length-1;
    matching(a,b,l,r);
  }

  public static void matching( Nut[] a, Bolt[] b, int l, int r){
    if (l>=r) {
      return;
    }
    
    int p = partition(a,l,r,b[r]);
    partition(b,l,r,a[p]);

    matching(a,b,l,p-1);
    matching(a,b,p+1,r);
  }

  public static int partition( Bolt[] a, int l, int r, Nut pivot) {
    int i = l;
    for (int j = l; j < r ; j++ ) {
      if (a[j].compareTo(pivot) > 0) {
        swap(a,i,j);
        i++;
      }
      else if (a[j].compareTo(pivot) == 0) {
        swap(a,j,r);
        j--;
      }
    }
    swap(a,i,r);
    return i;
  }

  public static int partition( Nut[] a, int l, int r, Bolt pivot) {
    int i = l;
    for (int j = l; j < r ; j++ ) {
      if (a[j].compareTo(pivot) < 0) {
        swap(a,i,j);
        i++;
      }
      else if (a[j].compareTo(pivot) == 0) {
        swap(a,j,r);
        j--;
      }
    }
    swap(a,i,r);
    return i;
  }
  public static void swap(NutBolt[] arr, int i, int j) {
    NutBolt temp = arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }
}
