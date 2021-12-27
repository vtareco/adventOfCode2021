import javax.jnlp.IntegrationService;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunPuzzle { // lowest total risk
    private static final String PUZZLE_15_FILEPATH = "src/main/resources/puzzle_15_exemplo";

    public static void main(String[] args) throws IOException {
        String filePath = args != null && args.length != 0 ? args[0] : PUZZLE_15_FILEPATH;
        int result = solvePuzzle1(filePath);
        System.out.println("result ---> " + result);
    }

    private static int solvePuzzle1(String filePath) throws IOException {
        int path = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            List<String> linhas = new ArrayList<>();
            for(String line; (line = br.readLine()) != null; ) {
                linhas.add(line);
            }

            int initial = Character.getNumericValue(linhas.get(0).charAt(0));
            int end = Character.getNumericValue(linhas.get(linhas.size()-1).charAt(linhas.get(linhas.size()-1).length()-1));
            path = initial + end;

            linhas.remove(linhas.get(0));
            linhas.remove(linhas.get(linhas.size()-1));

            for (int i = 0; i < linhas.size(); i++) {
                if(i+1 < linhas.size() ){
                    path += definePath(linhas.get(i),linhas.get(i+1));
                }

            }


        }
        return path;
    }

    private static int definePath(String in1, String in2) {
        int result = 0;

        int pos1 = Character.getNumericValue(in1.charAt(0));
        int pos2 = Character.getNumericValue(in2.charAt(0));
        if(pos1 <= pos2 ){
            result += pos1;
        }
        else{
            if(pos1 <= pos2 ){
                result += pos1;
            }
        }

        return result;
    }

    public final int findMin(final String[] words) {
        final String min = Arrays.stream(words).min(String.CASE_INSENSITIVE_ORDER).orElse(null);
        //final String max = Arrays.stream(words).max(String.CASE_INSENSITIVE_ORDER).orElse(null);
        return Integer.parseInt(min);
    }
}