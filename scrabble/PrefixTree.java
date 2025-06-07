import java.util.HashMap;

public class PrefixTree {

    private Node root;

    public PrefixTree() {
        root = new Node('\0', true);
    }

    public String search(String str) {
        str = str.toLowerCase();
        Node node = root;
        char c;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            node = node.findNext(c);
            if (node == null)
                break;
            if (node.isEnd())
                result = str.substring(0, i + 1);
        }
        return result;
    }

    public void insert(String str) {
        str = str.toLowerCase();
        int strLen = str.length();
        Node node = root;
        char c;
        for (int i = 0; i < strLen; i++) {
            c = str.charAt(i);
            node = node.addToNext(c, false);
            if (i == strLen - 1)
                node.setEnd();
        }
    }
    
    private class Node {
        private char character;
        private boolean isEnd;
        private HashMap<Character, Node> next;

        public Node(char c, boolean end) {
            character = c;
            isEnd = end;
            next = new HashMap<>();
        }

        public Node addToNext(char ch, boolean end) {
            if (next.containsKey(ch)) {
                return next.get(ch);
            }
            Node nextNode = new Node(ch, end);
            next.put(ch, nextNode);
            return nextNode;
        }

        public Node findNext(char ch) {
            if (next.containsKey(ch)) {
                return next.get(ch);
            }
            return null;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }
}
