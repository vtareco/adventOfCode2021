import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Puzzle3 { // TODO part 2
    private static final String PUZZLE_3_FILEPATH = "src/main/resources/puzzle_3";

    public static void main(String[] args) throws IOException {
        String filePath = args != null && args.length != 0 ? args[0] : PUZZLE_3_FILEPATH;
        int result = solvePuzzle2(filePath);
        System.out.println("result ---> " + result);
    }

    private static int solvePuzzle1(String filePath) throws IOException {
        return findGammaRate(filePath) *findIpsilonRate(filePath); // 693486
    }

    private static int findGammaRate(String filePath) throws IOException {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        List<String> list6 = new ArrayList<>();
        List<String> list7 = new ArrayList<>();
        List<String> list8 = new ArrayList<>();
        List<String> list9 = new ArrayList<>();
        List<String> list10 = new ArrayList<>();
        List<String> list11 = new ArrayList<>();
        List<String> list12 = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                list1.add(String.valueOf(line.charAt(0)));
                list2.add(String.valueOf(line.charAt(1)));
                list3.add(String.valueOf(line.charAt(2)));
                list4.add(String.valueOf(line.charAt(3)));
                list5.add(String.valueOf(line.charAt(4)));
                list6.add(String.valueOf(line.charAt(5)));
                list7.add(String.valueOf(line.charAt(6)));
                list8.add(String.valueOf(line.charAt(7)));
                list9.add(String.valueOf(line.charAt(8)));
                list10.add(String.valueOf(line.charAt(9)));
                list11.add(String.valueOf(line.charAt(10)));
                list12.add(String.valueOf(line.charAt(11)));
            }
        }

        String gammaRate = mostCommon(list1).concat(mostCommon(list2))
                .concat(mostCommon(list3)).concat(mostCommon(list4)).concat(mostCommon(list5))
                        .concat(mostCommon(list6)).concat(mostCommon(list7)).concat(mostCommon(list8))
                .concat(mostCommon(list9)).concat(mostCommon(list10)).concat(mostCommon(list11)).concat(mostCommon(list12));
        System.out.println("gammaRate ---> " + gammaRate);

        int decimal=Integer.parseInt(gammaRate,2);
        System.out.println("gammaRate decimal ---> " + decimal);
        return decimal;
    }

    private static int findIpsilonRate(String filePath) throws IOException {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        List<String> list6 = new ArrayList<>();
        List<String> list7 = new ArrayList<>();
        List<String> list8 = new ArrayList<>();
        List<String> list9 = new ArrayList<>();
        List<String> list10 = new ArrayList<>();
        List<String> list11 = new ArrayList<>();
        List<String> list12 = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                list1.add(String.valueOf(line.charAt(0)));
                list2.add(String.valueOf(line.charAt(1)));
                list3.add(String.valueOf(line.charAt(2)));
                list4.add(String.valueOf(line.charAt(3)));
                list5.add(String.valueOf(line.charAt(4)));
                list6.add(String.valueOf(line.charAt(5)));
                list7.add(String.valueOf(line.charAt(6)));
                list8.add(String.valueOf(line.charAt(7)));
                list9.add(String.valueOf(line.charAt(8)));
                list10.add(String.valueOf(line.charAt(9)));
                list11.add(String.valueOf(line.charAt(10)));
                list12.add(String.valueOf(line.charAt(11)));
            }
        }

        String gammaRate = leastCommon(list1).concat(leastCommon(list2))
                .concat(leastCommon(list3)).concat(leastCommon(list4)).concat(leastCommon(list5))
                .concat(leastCommon(list6)).concat(leastCommon(list7)).concat(leastCommon(list8))
                .concat(leastCommon(list9)).concat(leastCommon(list10)).concat(leastCommon(list11)).concat(leastCommon(list12));
        System.out.println("IpsilonRate ---> " + gammaRate);

        int decimal=Integer.parseInt(gammaRate,2);
        System.out.println("IpsilonRate decimal ---> " + decimal);
        return decimal;
    }

    private static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }

    private static String leastCommon(List<String> list1) {
        return mostCommon(list1).equals("1") ? "0" : "1";
    }

    private static int solvePuzzle2(String filePath) throws IOException {
        return findOxygenGenerator(filePath) *findCo2Scrubber(filePath); // 693486
    }

    private static int findOxygenGenerator(String filePath) throws IOException {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        List<String> list6 = new ArrayList<>();
        List<String> list7 = new ArrayList<>();
        List<String> list8 = new ArrayList<>();
        List<String> list9 = new ArrayList<>();
        List<String> list10 = new ArrayList<>();
        List<String> list11 = new ArrayList<>();
        List<String> list12 = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                list1.add(String.valueOf(line.charAt(0)));
                list2.add(String.valueOf(line.charAt(1)));
                list3.add(String.valueOf(line.charAt(2)));
                list4.add(String.valueOf(line.charAt(3)));
                list5.add(String.valueOf(line.charAt(4)));
                list6.add(String.valueOf(line.charAt(5)));
                list7.add(String.valueOf(line.charAt(6)));
                list8.add(String.valueOf(line.charAt(7)));
                list9.add(String.valueOf(line.charAt(8)));
                list10.add(String.valueOf(line.charAt(9)));
                list11.add(String.valueOf(line.charAt(10)));
                list12.add(String.valueOf(line.charAt(11)));
            }
        }

        String gammaRate = findOxygenGeneratorRating(list1).concat(findOxygenGeneratorRating(list2))
                .concat(findOxygenGeneratorRating(list3)).concat(findOxygenGeneratorRating(list4)).concat(findOxygenGeneratorRating(list5))
                .concat(findOxygenGeneratorRating(list6)).concat(findOxygenGeneratorRating(list7)).concat(findOxygenGeneratorRating(list8))
                .concat(findOxygenGeneratorRating(list9)).concat(findOxygenGeneratorRating(list10)).concat(findOxygenGeneratorRating(list11)).concat(findOxygenGeneratorRating(list12));
        System.out.println("OxygenGeneratorRating ---> " + gammaRate);

        int decimal=Integer.parseInt(gammaRate,2);
        System.out.println("OxygenGeneratorRating decimal ---> " + decimal);
        return decimal;
    }

    private static int findCo2Scrubber(String filePath) throws IOException {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        List<String> list6 = new ArrayList<>();
        List<String> list7 = new ArrayList<>();
        List<String> list8 = new ArrayList<>();
        List<String> list9 = new ArrayList<>();
        List<String> list10 = new ArrayList<>();
        List<String> list11 = new ArrayList<>();
        List<String> list12 = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                list1.add(String.valueOf(line.charAt(0)));
                list2.add(String.valueOf(line.charAt(1)));
                list3.add(String.valueOf(line.charAt(2)));
                list4.add(String.valueOf(line.charAt(3)));
                list5.add(String.valueOf(line.charAt(4)));
                list6.add(String.valueOf(line.charAt(5)));
                list7.add(String.valueOf(line.charAt(6)));
                list8.add(String.valueOf(line.charAt(7)));
                list9.add(String.valueOf(line.charAt(8)));
                list10.add(String.valueOf(line.charAt(9)));
                list11.add(String.valueOf(line.charAt(10)));
                list12.add(String.valueOf(line.charAt(11)));
            }
        }

        String gammaRate = findCo2ScrubberRating(list1).concat(findCo2ScrubberRating(list2))
                .concat(findCo2ScrubberRating(list3)).concat(findCo2ScrubberRating(list4)).concat(findCo2ScrubberRating(list5))
                .concat(findCo2ScrubberRating(list6)).concat(findCo2ScrubberRating(list7)).concat(findCo2ScrubberRating(list8))
                .concat(findCo2ScrubberRating(list9)).concat(findCo2ScrubberRating(list10)).concat(findCo2ScrubberRating(list11)).concat(findCo2ScrubberRating(list12));
        System.out.println("findCo2ScrubberRating ---> " + gammaRate);

        int decimal=Integer.parseInt(gammaRate,2);
        System.out.println("findCo2ScrubberRating decimal ---> " + decimal);
        return decimal;
    }

    private static String findOxygenGeneratorRating(List<String> list) {
        String result = null;
        long countOne = Collections.frequency(list, "1");
        long countZero = Collections.frequency(list, "0");

        if (countOne == countZero){
            System.out.println("findOxygenGeneratorRating igual ---> " + list);
        }

        System.out.println("findOxygenGeneratorRating countOne ---> " + countOne);
        System.out.println("findOxygenGeneratorRating countZero ---> " + countZero);

        return countZero > countOne ? "0" : "1";
    }

    private static String findCo2ScrubberRating(List<String> list) {
        String result = null;
        long countOne = Collections.frequency(list, "1");
        long countZero = Collections.frequency(list, "0");
        return countZero > countOne ? "1" : "0";
    }
}