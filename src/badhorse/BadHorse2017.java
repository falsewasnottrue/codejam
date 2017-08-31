package badhorse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class BadHorse2017 {
    public static void main(String... args) throws Exception {

        // Idea: Try and split up

        final String filename = "src/badhorse/A-small-practice-1.in";

        final BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
        String line = br.readLine(); // ignore first line
        int c = 1; // case count

        while ((line = br.readLine()) != null) {

            // import next case
            final int count = Integer.parseInt(line); // number of pairs
            final List<String> lines = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                lines.add(br.readLine());
            }

            // 1. break down lines into pairs
            final List<List<String>> pairs = getPairs(lines);

            // 2. find set of baddies
            final Set<String> baddies = getBaddies(pairs);

            for (final String baddy : baddies) {
                final Set<String> enemies = enemyOf(baddy, pairs);
            }

            for (String baddy : baddies) {
                System.out.println(baddy);
            }

            //System.out.println("Case #" + (c++) + ": " + (result ? "Yes" : "No"));
            c++;
        }
    }

    private static List<List<String>> getPairs(final List<String> lines) {
        final List<List<String>> pairs = new ArrayList<>();
        for (final String line : lines) {
            pairs.add(Arrays.asList(line.split(" ")));
        }

        return pairs;
    }

    private static Set<String> getBaddies(final List<List<String>> pairs) {
        final Set<String> baddies = new HashSet<>();

        return baddies;
    }
}
