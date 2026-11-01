import java.io.*;
import java.util.*;

public class CRunningMiles {
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

        //Used AI hints to help me work through the logic, since this is a harder problem than I've solved before, then implemented 
        //everything myself
        int t = fs.nextInt();
        while(t-- > 0) {
            int n = fs.nextInt();
            int[] b = new int[n];
            for(int i = 0; i < n; i++) {
                b[i] = fs.nextInt();
            }
            int[] left = new int[n];
            int[] right = new int[n];
            left[0] = b[0];
            for(int i = 1; i < n; i++) {
                if(left[i-1] > b[i] + i) {
                    left[i] = left[i-1];
                } else {
                    left[i] = b[i] + i;
                }
            }
            right[n-1] = b[n-1]-(n-1);
            for(int i = n-2; i >= 0; i--) {
                if(right[i+1] > b[i] - i) {
                    right[i] = right[i+1];
                } else {
                    right[i] = b[i] - i;
                }
            }
            long score = Integer.MIN_VALUE;
            for(int i = 1; i < n-1; i++) {
                score = Math.max(score, left[i-1] + right[i+1] + b[i]);
            }
            out.append(score).append("\n");
        }

        System.out.print(out);
    }
}