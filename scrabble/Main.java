import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        ScrabbleSolver solver = new ScrabbleSolver("./files/nsf2023.txt", "./files/scrabblepoints.txt");
        solver.findWords("aaenprkltico");
        HashMap<Integer, HashSet<String>> res = solver.getWordValues();

        for (int key : res.keySet()) {
            System.out.print(key + ": ");
            for (String word : res.get(key)) {
                System.out.print(word + " ");
            }
            System.out.println("\n");
        }
    }
}