package magicka;

public class Conflict {

  private char a, b;

  public Conflict(char a, char b) {
    this.a = a;
    this.b = b;
  }

  public char getA() { return a; }
  public char getB() { return b; }

  @Override
  public String toString() {
    return "(" + a + "<->" + b + ")";
  }
}
