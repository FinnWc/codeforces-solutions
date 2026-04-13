import java.io.*;
import java.util.*;

public class A_Blocked {
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
            Integer[] a = new Integer[n];
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            Arrays.sort(a, Collections.reverseOrder());
            boolean sameNum = false;
            if(n == 1) {
                out.append(1).append("\n");
                continue;
            }
            for(int i = 0; i < n-1; i++) {
                if(a[i] == a[i+1]) {
                    sameNum = true;
                    break;
                }
            }
            if(sameNum) {
                out.append(-1 + "\n");
            } else {
                for(int i = 0; i < n; i++) {
                    out.append(a[i] + " ");
                }
                out.append("\n");
            }
        }
        System.out.print(out);
    }
}