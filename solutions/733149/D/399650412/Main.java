
import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        String s = fs.next();
        //for this problem, I referenced the KMP code from the prev problem becuase it seemed obviously 
        //like a KMP problem, but I had a bit of trouble implementing this problem and counting specifically how many times the prefix appears. 
        //used some Ai hints and help. 

        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            count[pi[i]]++;
        }
        for (int i = n; i > 0; i--) {
            count[pi[i - 1]] += count[i];
        }
        for (int i = 1; i <= n; i++) {
            count[i]++;
        }
        ArrayList<Integer> lengths = new ArrayList<>();
        int len = n;
        while (len > 0) {
            lengths.add(len);
            len = pi[len - 1];
        }
        Collections.reverse(lengths);
        StringBuilder out = new StringBuilder();
        out.append(lengths.size()).append('\n');

        for (int length : lengths) {
            out.append(length).append(" ").append(count[length]).append('\n');
        }

        System.out.print(out);
    }
}
