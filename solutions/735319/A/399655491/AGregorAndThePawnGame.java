import java.io.*;
import java.util.*;

public class AGregorAndThePawnGame {
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
            String oppS = fs.next();
            String gregS = fs.next();

            int[] opp = new int[n];
            int[] greg = new int[n];

            for(int i = 0; i < n; i++) {
                opp[i] = oppS.charAt(i) - '0';
            }
            for(int i = 0; i < n; i++) {
                greg[i] = gregS.charAt(i) - '0';
            }
            long sum = 0;
            for(int i = 0; i < n; i++) {
                if(greg[i] == 1) {
                    if(opp[i] == 0) {
                        sum++;
                        opp[i] = 2;
                    } else if(i == 0 && opp[1] == 1) {
                        sum++;
                        opp[1] = 2;
                    } else if(i == n-1 && opp[i-1] == 1) {
                        sum++;
                        opp[i-1] = 2;
                    } else if(i >= 1 && opp[i-1] == 1) {
                        sum++;
                        opp[i-1] = 2;
                    } else if(i < n-1 && opp[i+1] == 1) {
                        sum++;
                        opp[i+1] = 2;
                    }
                }
            }
            out.append(sum).append("\n");
        }

        System.out.print(out);
    }
}