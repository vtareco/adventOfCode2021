import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Puzzle1 {
    private static String PUZZLE_1_FILEPATH = "src/main/resources/puzzle_1";

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = args != null && args.length != 0 ? args[0] : PUZZLE_1_FILEPATH;
        int result = solvePuzzle2(filePath);
        System.out.println("result ---> " + result);
    }

    private static String solvePuzzle1(String filePath) throws FileNotFoundException {
        int result = 0;
        Scanner scanner = new Scanner(new File(filePath));
        int[] tall = new int[2001];

        for(int i = 0; scanner.hasNextInt(); ++i) {
            tall[i] = scanner.nextInt();
            if (i > 0 && tall[i] >= tall[i - 1]) {
                ++result;
            }

            System.out.println("index ---> " + tall[i]);
        }
        return String.valueOf(result);
    }

    private static int solvePuzzle2(String filePath) throws FileNotFoundException {
        List<Integer> sums = getSums(filePath);
        int count = 0;
        for(int i = 0; i < sums.size(); i++) {
            if ( i+1 != sums.size() && sums.get(i+1) > sums.get(i) ) {
                count++;
            }
        }
        System.out.println("increased ---> " + count);
        return count;
    }

    private static List getSums(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        int[] tall = new int[2001];

        List somas = new ArrayList<Integer>();
        for(int i = 0; scanner.hasNextInt(); i++) {
            tall[i] = scanner.nextInt();
        }

        for(int i = 0; i < tall.length; i++) {
            if (i+2 < tall.length) {
                int conta = tall[i] + tall[i+1] + tall[i+2];

             //   System.out.println("1 ---> "+tall[i-3]);
               // System.out.println("2 ---> "+tall[i-2]);
               // System.out.println("3 ---> "+tall[i-1]);

              //  System.out.println("contA ---> "+conta);
                somas.add(conta);
            }
        }




        return somas;
    }
}