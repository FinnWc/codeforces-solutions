import java.io.*;
import java.util.*;

public class GInscribedFigures {
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

        int n = fs.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) { a[i] = fs.nextInt(); }
        long sum = 0;
        for(int i = 0; i < n-1; i++) {
            if((a[i] == 2 && a[i+1] == 3) || (a[i] == 3 && a[i+1] == 2)) {
                out.append("Infinite");
                System.out.print(out);
                return;
            }
            if((a[i] == 1 && a[i+1] == 2) || (a[i] == 2 && a[i+1] == 1)) {
                sum += 3;
            } else if((a[i] == 1 && a[i+1] == 3) || (a[i] == 3 && a[i+1] == 1)) {
                sum += 4;
            } else if(a[i] == 3 && a[i+1] == 2) {
                sum += 2;
            }
            //AI helped me realize this error. I would've probably realized myself, but I'm running out of time for this pset and want to solve one more
            if(i >= 1 && a[i - 1] == 3 && a[i] == 1 && a[i + 1] == 2) {
                sum--;
            }
        }
        out.append("Finite\n" + sum);
        System.out.print(out);
    }
}