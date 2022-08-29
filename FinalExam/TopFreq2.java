import edu.princeton.cs.algs4.*;

public class TopFreq2 {
    public static void main(String[] args) {
      Stopwatch time = new Stopwatch();
      int k = Integer.parseInt(args[0]);
      int N = Integer.parseInt(args[1]);
  
      ST<String,Integer> table = new ST<>();
  
      while (!StdIn.isEmpty()) {
        String word = StdIn.readString();
        if (word.length() >= k) {
          if (table.get(word) == null) {
            table.put(word,1);
          }
          else {
            table.put(word,table.get(word)+1);
          }
        }
      }
  
      for (int j = 0;j < N ;j++ ) {
        String max = "";
        table.put(max,0);
        for (String key: table.keys() ) {
          if (table.get(key) > table.get(max)) {
            max = key;
          }
        }
        System.out.println(max + " " +table.get(max));
        table.remove(max);
      }
      System.out.println("time: " + time.elapsedTime());
    }
  }