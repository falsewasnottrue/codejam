package magicka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Magicka {

  public static void main(String... args) throws Exception {

    String fn = "src/magicka/B-large-practice.in";

    BufferedReader br = new BufferedReader(new FileReader(new File(fn)));
    String line = br.readLine(); // drop case numbers line
    int i=1;
    while((line = br.readLine()) != null) {
      MagickaCase c = new MagickaCase(line);
      List<Character> result = c.invoke();
      System.out.println("Case #" + (i++) + ": " + result);
    }
  }
}
