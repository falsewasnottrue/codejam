package minscalar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinScalar {

  public static void main(String... args) throws Exception {

    String filename = "src/minscalar/A-large-practice.in";
    BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
    String line = br.readLine(); // drop case# line

    int i=1;
    while((line = br.readLine()) != null) {
      List<BigDecimal> vec1 = str2Vec(br.readLine());
      List<BigDecimal> vec2 = str2Vec(br.readLine());

      Collections.sort(vec1);
      Collections.sort(vec2);

      Collections.reverse(vec1);

      BigDecimal result = scalarProd(vec1, vec2);

      System.out.println("Case #" + (i++) + ": " + result);
    }
  }

  private final static List<BigDecimal> str2Vec(String s) {
    final List<BigDecimal> result = new ArrayList<>();
    for (String i : Arrays.asList(s.split(" "))) {
      result.add(new BigDecimal(i));
    }

    return result;
  }

  private final static BigDecimal scalarProd(List<BigDecimal> v1, List<BigDecimal> v2) {
    BigDecimal result = BigDecimal.ZERO;
    for (int i=0; i<v1.size(); i++) {
      result = result.add( v1.get(i).multiply(v2.get(i)) );
    }

    return result;
  }
}
