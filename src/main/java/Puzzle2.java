import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Puzzle2 {
    private static final String PUZZLE_2_FILEPATH = "src/main/resources/puzzle_2";
    private static final String[] MOVES = {"up", "down"};

    public static void main(String[] args) throws IOException {
        String filePath = args != null && args.length != 0 ? args[0] : PUZZLE_2_FILEPATH;
        int result = solvePuzzle2(filePath);
        System.out.println("result ---> " + result);
    }

    private static int solvePuzzle1(String filePath) throws IOException {
        int countH = 0;
        int countD = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                System.out.println(" ---> " + line);
                String[] values = line.split(" ");

                if(isHorizontal(values[0])){
                    countH += Integer.parseInt(values[1]);
                }
                else if(isUp(values[0])){
                        countD -= Integer.parseInt(values[1]);
                        System.out.println("up ---> " + countD);
                }

                else if(isDown(values[0])){
                        countD += Integer.parseInt(values[1]);
                        System.out.println("d ---> " + countD);
                }
            }
        }
        return countD*countH;
    }

    private static int solvePuzzle2(String filePath) throws IOException {
        int countH = 0;
        int countD = 0;
        int countA = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                System.out.println(" ---> " + line);
                String[] values = line.split(" ");

                if(isHorizontal(values[0])){
                    countH += Integer.parseInt(values[1]);
                    countD += Integer.parseInt(values[1])*countA;

                }
                else if(isUp(values[0])){
                    countA -= Integer.parseInt(values[1]);
                    System.out.println("up ---> " + countD);
                }

                else if(isDown(values[0])){
                    countA += Integer.parseInt(values[1]);
                    System.out.println("d ---> " + countD);
                }
            }
        }
        return countD*countH;
    }

    private static boolean isHorizontal(String value) {
        return value.equals("forward");
    }

    private static boolean isUp(String value) {
        return value.equals("up");
    }

    private static boolean isDown(String value) {
        return value.equals("down");
    }
}