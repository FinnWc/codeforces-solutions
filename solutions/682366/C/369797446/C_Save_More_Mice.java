import java.io.*;
import java.util.*;

public class C_Save_More_Mice {
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
            int k = fs.nextInt();
            Integer[] x = new Integer[k];
            for(int i = 0; i < k; i++) { x[i] = fs.nextInt(); }
            Arrays.sort(x, Collections.reverseOrder());
            long counter = 0;
            long totalNumMice = 0;
            for(int i = 0; i < k; i++) {
                if(counter >= x[i]) {
                    break;
                }
                counter += n-x[i];
                totalNumMice++;
            }
            out.append(totalNumMice + "\n" );
        }

        System.out.print(out);
    }
}