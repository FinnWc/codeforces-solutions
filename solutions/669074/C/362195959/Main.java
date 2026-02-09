
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
        long t = fs.nextInt();
        while(t-- > 0) {
            int m = fs.nextInt();
            int n = fs.nextInt();
            /*Was having lots of trouble with the below logic, tried many things, but 
            ultimately consulted with chatGPT and landed on the next two lines*/
            long cells = 1L * m * n;
            long minNum = (cells + 2) / 3;
            out.append(minNum).append("\n");
        }
        System.out.print(out);
    }
}
