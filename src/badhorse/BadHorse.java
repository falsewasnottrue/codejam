package badhorse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BadHorse {

  public static void main(String... args) throws Exception {

    // TODO new idea:
    //   find all names
    //   find conflicts for all names
    //   see if conflicts for any name contain a conflict

    final String filename  = "src/badhorse/A-small-practice-1.in";

    final BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
    String line = br.readLine();
    int c = 1;

    while ((line = br.readLine()) != null) {
      final int count = Integer.parseInt(line);
      final List<String> input = new ArrayList<>();

      for (int i=0; i<count; i++) {
        input.add(br.readLine());
      }

      final List<String> opponents = opponents(input);
      final Map<String, List<String>> conflicts = conflicts(opponents, input);
      final boolean result = splittable(conflicts, input);

      System.out.println("Case #" + (c++) + ": " + (result ? "Yes" : "No"));
    }
  }

  private static List<String> opponents(List<String> input) {
    Set<String> oppSet = new HashSet<>();
    for (final String s : input) {
      oppSet.add(s.split(" ")[0]);
      oppSet.add(s.split(" ")[1]);
    }

    return new ArrayList<>(oppSet);
  }

  private static Map<String, List<String>> conflicts(List<String> opponents, List<String> input) {
    Map<String, List<String>> conflicts = new HashMap<>();

    for (String opponent : opponents) {
      List<String> cs = new ArrayList();
      for (final String s : input) {
        if (opponent.equals(s.split(" ")[0])) {
          cs.add(s.split(" ")[1]);
        } else if (opponent.equals(s.split(" ")[1])) {
          cs.add(s.split(" ")[1]);
        }
      }

      conflicts.put(opponent, cs);
    }

    return conflicts;
  }

  private static boolean splittable(Map<String, List<String>> conflicts, List<String> input) {
    for (List<String> cs : conflicts.values()) {
      for (String s : input) {
        String opp0 = s.split(" ")[0];
        String opp1 = s.split(" ")[1];

        if (cs.contains(opp0) && cs.contains(opp1)) {
          return false;
        }
      }
    }

    return true;
  }
}
