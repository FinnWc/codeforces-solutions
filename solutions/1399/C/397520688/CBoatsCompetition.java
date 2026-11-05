import java.io.*;
import java.util.*;

public class CBoatsCompetition {
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
            int[] w = new int[n];
            for(int i = 0; i < n; i++) {
                w[i] = fs.nextInt();
            }
            int num = 0;
            Arrays.sort(w);
            for(int i = 2; i <= 2*n; i++) {
                int q, p, tempNum;
                q = 0;
                p = n-1;
                tempNum = 0;
                while(q < p) {
                    if(w[q] + w[p] == i) {
                        tempNum++;
                        q++;
                        p--;
                    } else if(w[q] + w[p] < i) {
                        q++;
                    } else {
                        p--;
                    }
                }
                num = Math.max(num,tempNum);
            }
            out.append(num).append("\n");
        }

        System.out.print(out);
    }
}