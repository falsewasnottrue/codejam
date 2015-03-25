package reversewords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

  public static void main(String... args) throws Exception {

    String filename = "src/reversewords/B-large-practice.in";
    BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
    String line = br.readLine(); // drop case# line
    int i=1;

    while ((line = br.readLine()) != null) {
      String[] tokens = line.split(" ");
      String result = String.join(" ", reverse(tokens));

      System.out.println("Case #" + (i++) + ": " + result);
    }

  }

  private static List<String> reverse(String[] in) {
    List<String> res = new ArrayList<String>();
    for (int i=in.length-1; i>=0; i--) {
      res.add(in[i]);
    }
    return res;
  }

}
