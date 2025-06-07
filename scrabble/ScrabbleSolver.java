import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScrabbleSolver {

    private Wordlist list;
    private HashSet<String> words;
    private HashMap<Integer, HashSet<String>> wordValues;
    private HashMap<Character, Integer> charValues;

    public ScrabbleSolver(String dict, String pointsfile) {
        list = new Wordlist(dict);
        words = new HashSet<>();
        wordValues = new HashMap<>();
        charValues = new HashMap<>();
        getCharValues(pointsfile);
    }

    public void findWords(String letters) {
        Permutation permutations = new Permutation(letters);
        String word;
        for (String perm : permutations) {
            word = list.search(perm);
            if (!(word.equals("")))
                words.add(word);
        }
        findWordValues();
    }

    private void findWordValues() {
        int points;
        for (String word : words) {
            points = getScrabbleValue(word);
            if (!wordValues.containsKey(points))
                wordValues.put(points, new HashSet<String>());
            wordValues.get(points).add(word);
        }
    }

    public HashMap<Integer, HashSet<String>> getWordValues() {
        return wordValues;
    }

    private int getScrabbleValue(String str) {
        int points = 0;
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            points += charValues.get(c);      
        }
        return points;
    }



    private void getCharValues(String valuefile) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(valuefile));
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        char c;
        int points;
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                c = scanner.next().toLowerCase().charAt(0);
                points = scanner.nextInt();
                charValues.put(c, points);
            }
        }
    }
}

