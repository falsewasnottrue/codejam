package badhorse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
      boolean result = splitable(input);

      System.out.println("Case #" + (c++) + ": " + (result ? "Yes" : "No"));
    }
  }

  private static boolean splitable(List<String> input) {
    final List<String> group1 = new ArrayList<>();
    final List<String> group2 = new ArrayList<>();

    final List<String> noconflict = new ArrayList<>();
    for (final String i : input) {
      final String opp1 = i.split(" ")[0];
      final String opp2 = i.split(" ")[1];

      if (group1.contains(opp1)) {
        // opp2 must go into group2
        if (group2.contains(opp2)) {
          return false;
        } else {
          group2.add(opp2);
        }
      } else if (group2.contains(opp2)) {
        // opp2 must go into group1
        if (group1.contains(opp2)) {
          return false;
        } else {
          group1.add(opp1);
        }
      } else if (group1.contains(opp2)) {
        // opp1 must go into group2
        if (group2.contains(opp1)) {
          return false;
        } else {
          group2.add(opp1);
        }
      } else if (group2.contains(opp2)) {
        // opp1 must go into group1
        if (group1.contains(opp1)) {
          return false;
        } else {
          group1.add(opp1);
        }
      } else {
        // opp1, opp2 are in neither group
        noconflict.add(opp1 + " " + opp2);
      }
    }

    for (final String i : noconflict) {
      final String opp1 = i.split(" ")[0];
      final String opp2 = i.split(" ")[1];

      if (group1.contains(opp1)) {
        // opp2 must go into group2
        if (group2.contains(opp2)) {
          return false;
        } else {
          group2.add(opp2);
        }
      } else if (group2.contains(opp2)) {
        // opp2 must go into group1
        if (group1.contains(opp2)) {
          return false;
        } else {
          group1.add(opp1);
        }
      } else if (group1.contains(opp2)) {
        // opp1 must go into group2
        if (group2.contains(opp1)) {
          return false;
        } else {
          group2.add(opp1);
        }
      } else if (group2.contains(opp2)) {
        // opp1 must go into group1
        if (group1.contains(opp1)) {
          return false;
        } else {
          group1.add(opp1);
        }
      } else {
        // opp1, opp2 are in neither group
        group1.add(opp1);
        group2.add(opp2);
      }
    }
    return true;
  }
}
