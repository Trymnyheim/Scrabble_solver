import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Wordlist {

    private String dictionary;
    private List<String> lines;
    private PrefixTree pTree;

    public Wordlist(String dict) {
        dictionary = dict;
        try {
            lines = Files.readAllLines(Paths.get(dictionary));
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        buildPrefixTree();
    }

    private void buildPrefixTree() {
        pTree = new PrefixTree();
        for (String line : lines) {
            pTree.insert(line);
        }
    }

    public String search(String str) {
        return pTree.search(str);
    }
    
}