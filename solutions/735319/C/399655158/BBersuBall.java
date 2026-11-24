import java.io.*;
import java.util.*;
 
public class BBersuBall {
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
 
    //solved in the homework
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
 
        int n = fs.nextInt();
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            b[i] = fs.nextInt();
        }
        int m = fs.nextInt();
        int[] g = new int[m];
        for(int i = 0; i < m; i++) {
            g[i] = fs.nextInt();
        }
 
        Arrays.sort(b);
        Arrays.sort(g);
        int boyP = 0;
        int girlP = 0;
        long sum = 0;
        while(boyP < n && girlP < m) {
            if(Math.abs(b[boyP]-g[girlP]) <= 1) {
                boyP++;
                girlP++;
                sum++;
            } else if(b[boyP] < g[girlP]) {
                boyP++;
            } else {
                girlP++;
            }
        }
        out.append(sum);
 
        System.out.print(out);
    }
}