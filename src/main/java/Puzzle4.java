import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Puzzle4 { // PLAY BINGO TODO
    private static final String PUZZLE_4_FILEPATH = "src/main/resources/puzzle_4_exemplo";
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 5;

    public static void main(String[] args) throws IOException {
        String filePath = args != null && args.length != 0 ? args[0] : PUZZLE_4_FILEPATH;
        int result = solvePuzzle1(filePath);
        System.out.println("result ---> " + result);
    }

    private static int solvePuzzle1(String filePath) throws IOException {
        int ultimoNumeroMarcado = 0;
        int somaNumerosNaoMarcados = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            List<String> numerosJogo = Arrays.asList(br.readLine().split(","));
            List<int[][]> boards = generateBoards(br);

            List<Integer> colunaNumerosMarcados = new ArrayList<>();
            List<Integer> linhaNumerosMarcados = new ArrayList<>();
            Set numeroMarcados = new HashSet();
            int numeroBoard = -1;

            for (String str : numerosJogo){
            for (int[][] board : boards){
                int row = 0;
                int col = 0;
                for (int a = 0; a < NUM_ROWS; a++) {
                    for (int b = 0; b < NUM_COLS; b++) {
                        int aux = board[a][b];
                       // boolean answer = numerosJogo.stream().anyMatch(str -> aux == Integer.parseInt(str));
                        if(aux == Integer.parseInt(str)){
                            numeroBoard = aux;

                            linhaNumerosMarcados.add(row);
                            colunaNumerosMarcados.add(col);
                            numeroMarcados.add(numeroBoard);

                            System.out.println(numeroBoard+"------------- "+linhaNumerosMarcados);
                        }

                        if(hasBingoRow(linhaNumerosMarcados)){
                            System.out.println(" ultimoNumeroMarcado "+numeroBoard);
                            System.out.println(" numeroMarcados "+numeroMarcados);

                            ultimoNumeroMarcado = numeroBoard;
                            break;
                        }
                        col++;
                    }
                    row++;
                }


            }
        }
        }

        return somaNumerosNaoMarcados*ultimoNumeroMarcado;
    }



    private static List<int[][]> generateBoards(BufferedReader br) throws IOException {
        List<int[][]> boards = new ArrayList<>();
        int[][] board = new int[NUM_ROWS][NUM_COLS];
        int row = 0;
        for(String line; (line = br.readLine()) != null; ) {
            if(!line.isEmpty()){
                List<String> aux = Arrays.asList(line.split("\\s+"));
                List<String> numerosLinha = aux.stream()
                        .filter(t -> !t.isEmpty())
                        .collect(Collectors.toList());
                for (int i = 0; i < numerosLinha.size(); i++){
                    board[row][i] =  Integer.parseInt(numerosLinha.get(i));
                }
                row++;

                if(row % NUM_ROWS == 0){
                   // System.out.println("board criado");
                    boards.add(board);
                    board = new int[NUM_ROWS][NUM_COLS];
                    row = 0;
                }
            }
        }
        return boards;
    }




    private static boolean hasBingoRow(List<Integer> linhaNumerosMarcados) {
        long count1 = Collections.frequency(linhaNumerosMarcados, 0);
        long count2 = Collections.frequency(linhaNumerosMarcados, 1);
        long count3 = Collections.frequency(linhaNumerosMarcados, 2);
        long count4 = Collections.frequency(linhaNumerosMarcados, 3);
        long count5 = Collections.frequency(linhaNumerosMarcados, 4);

        return (count1 == NUM_ROWS) || (count2 == NUM_ROWS) ||
                (count3 == NUM_ROWS)|| (count4 == NUM_ROWS) || (count5 == NUM_ROWS);
    }

}