package magicka;

import java.util.Optional;

public class Combination {

  private final char e1, e2, product;

  public Combination(char e1, char e2, char product) {
    this.e1 = e1;
    this.e2 = e2;
    this.product = product;
  }

  public Optional<Character> combine(char a, char b) {
    if ((a == e1 && b == e2) || (a == e2 && b == e1)) {
      return Optional.of(product);
    }

    return Optional.empty();
  }

  @Override
  public String toString() {
    return "("+e1+","+e2+" -> "+product+")";
  }
}
