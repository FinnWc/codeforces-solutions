import java.io.*;
import java.util.*;

public class BTenzingAndBooks {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int x = fs.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[n];
            int cKnowledge = 0;
            int tempVal;
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextInt();
            }
            for (int i = 0; i < n; i++) {
                c[i] = fs.nextInt();
            }
            for (int i = 0; i < 3; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0) {
                        tempVal = a[j];
                        if((tempVal | x) != x) {
                            break;
                        }
                        cKnowledge |= tempVal;
                    }
                    if(i == 1) {
                        tempVal = b[j];
                        if((tempVal | x) != x) {
                            break;
                        }
                        cKnowledge |= tempVal;
                    }
                    if(i == 2) {
                        tempVal = c[j];
                        if((tempVal | x) != x) {
                            break;
                        }
                        cKnowledge |= tempVal;
                    }
                }
            }
            if (cKnowledge != x) {
                out.append("NO\n");
            } else {
                out.append("YES\n");
            }
        }

        System.out.print(out);
    }
}