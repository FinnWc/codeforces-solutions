import java.io.*;
import java.util.*;

public class E_Mocha_and_Hiking {
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
            int[] a = new int[n+1];
            for(int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }
            if(a[1] == 1) {
                out.append((n+1) + " ");
                for(int i = 1; i <= n; i++) {
                    out.append(i + " ");
                }
                out.append("\n");
            } else if(a[n] == 0) {
                for(int i = 1; i <= n; i++) {
                    out.append(i + " ");
                }
                out.append((n+1) + "\n");
            } else {
                boolean flag = false;
                for(int i = 1; i <= n; i++) {
                    if(a[i] == 0 && a[i+1] == 1 && !flag) {
                        out.append(i + " " + (n+1) + " ");
                        flag = true;
                    } else {
                        out.append(i + " ");
                    }
                }
                out.append("\n");
            }
        }
        System.out.print(out);
    }
}