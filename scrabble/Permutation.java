import java.util.Arrays;
import java.util.Iterator;

public class Permutation implements Iterable<String>{

    private char[] array;

    public Permutation(String str) {
        array = str.toCharArray();
        Arrays.sort(array);
    }
    
    public String get() {
        return new String(array);
    }

    // Finds next lexografic permutation of array
    public boolean nextPermutation() {
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }

        if (i < 0)
            return false;

        int j = array.length - 1;
        while (array[j] <= array[i]) {
            j--;
        }

        swap(i, j);
        reverse(i + 1, array.length - 1);
        return true;
    }

    private void swap(int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void reverse(int left, int right) {
        while (left < right) {
            swap(left++, right--);
        }
    }

    @Override
    public PermutationIterator iterator() {
        return new PermutationIterator();
    }

    private class PermutationIterator implements Iterator<String> {

        String current = new String(array);

        @Override
        public boolean hasNext() {
            return !(current.equals(""));
        }

        @Override
        public String next() {
            String next = current;
            if (nextPermutation())
                current = new String(array);
            else
                current = "";
            return next;
        }
    }
}
