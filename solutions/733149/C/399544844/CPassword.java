
import java.io.*;
import java.util.*;

public class CPassword {
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

    //I've never worked through a KMP problem before, tried to implement my own solution but it kept being too slow O(n^2)
    //I worked through this with AI to learn how to implement the KMP prefix and now I understand it much better. 
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        String s = fs.next();
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
        int maxMiddle = 0;
        for (int i = 0; i < n - 1; i++) {
            maxMiddle = Math.max(maxMiddle, pi[i]);
        }
        int len = pi[n - 1];
        while (len > 0) {
            if (maxMiddle >= len) {
                System.out.println(s.substring(0, len));
                return;
            }
            len = pi[len - 1];
        }
        System.out.println("Just a legend");
    }
}
