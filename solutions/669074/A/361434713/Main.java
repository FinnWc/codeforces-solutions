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
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt(); 
        while(t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            char[] sSorted = s.toCharArray();
            Arrays.sort(sSorted);
            int counter = 0;
            for(int i = 0; i < n; i++) {
                if((s.charAt(i) != (sSorted[i]))) {
                    counter++;
                }
            }
            out.append(counter);
            out.append("\n"); 
        }
        System.out.print(out);
    }
}