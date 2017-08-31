package magicka;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MagickaCase {

  private List<Combination> combinations;
  private List<Conflict> conflicts;
  private List<Character> invocations;

  public MagickaCase(final String line) {

    String[] tokens = line.split(" ");

    combinations = new ArrayList<Combination>();
    int combinationsCount = Integer.parseInt(tokens[0]);
    //System.out.println("#combinations " + combinationsCount);
    for (int i=1; i<combinationsCount+1; i++) {
      char[] cc = tokens[i].toCharArray();
      //System.out.println(cc);
      combinations.add(new Combination(cc[0], cc[1], cc[2]));
    }

    conflicts = new ArrayList<Conflict>();
    int conflictsCount = Integer.parseInt(tokens[combinationsCount+1]);
    //System.out.println("#conflicts " + conflictsCount);
    for (int i=1; i<conflictsCount+1; i++) {
      char[] cc = tokens[combinationsCount+1+i].toCharArray();
      //System.out.println(cc);
      conflicts.add(new Conflict(cc[0], cc[1]));
    }

    invocations = new ArrayList<Character>();
    int invocationsCount = Integer.parseInt(tokens[combinationsCount+conflictsCount+2]);
    //System.out.println("#invocations " + invocationsCount);
    String cc = tokens[combinationsCount+conflictsCount+3];
    //System.out.println(cc);
    for (int i=0; i<invocationsCount; i++) {
      invocations.add(cc.toCharArray()[i]);
    }
  }

  public List<Character> invoke() {
    List<Character> result = new ArrayList<Character>();
    for (final Character c : invocations) {
      result.add(c);

      if (result.size() > 1) {
        // Test for combinations
        char last = result.get(result.size()-1);
        char penLast = result.get(result.size()-2);
        for (Combination combination : combinations) {
          Optional<Character> combined = combination.combine(last, penLast);
          if (combined.isPresent()) {
            result.remove(result.size()-1);
            result.remove(result.size()-1);
            result.add(combined.get());
          }
        }

        // Test for conflicts
        for (Conflict conflict : conflicts) {
          if (result.contains(conflict.getA()) && result.contains(conflict.getB())) {
            result = new ArrayList<Character>();
          }
        }
      }
    }

    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(combinations).append('\n')
            .append(conflicts).append('\n')
            .append(invocations);
    return sb.toString();
  }
}
