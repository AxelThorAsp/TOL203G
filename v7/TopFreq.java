import edu.princeton.cs.algs4.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;


public class TopFreq {
  private TopFreq(){}

  static int n = 0;
  static ArrayList<String> kWords = new ArrayList<>();

  public static void main(String[] args) {
    int N = 5;
    int k = 3;

    String[] allWords = StdIn.readAllStrings();

    for(String word : allWords){
      if (word.length()>=k) {
        kWords.add(word);
      }
    }

    Collections.sort(kWords);

    List<String> words = kWords.stream().distinct().collect(Collectors.toList());

    ArrayList<Integer> freq = new ArrayList<>();

    for (String word : words) {
      freq.add(Collections.frequency(kWords,word));
    }

    ArrayList freqCopy = (ArrayList<String>) freq.clone();

    Collections.sort(freq);
    Collections.reverse(freq);

    for (int i=0;i<N ; i++) {
      int index = freqCopy.indexOf(freq.get(i));
      if (index == -1) {
        break;
      }
      else {
        System.out.println(words.get(index) + " " + freqCopy.get(index));
        freqCopy.set(index,-1); //repeating values
      }
    }

  }
}
