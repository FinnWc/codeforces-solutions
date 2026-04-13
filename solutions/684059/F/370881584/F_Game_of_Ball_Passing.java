import java.io.*;
import java.util.*;

public class F_Game_of_Ball_Passing {
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
            int[] a = new int[n];
            long sum = 0;
            long max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt(); 
                sum += a[i];
                max = Math.max(max, a[i]);   
            }
            if(sum == 0) {
                out.append(0 + "\n");
            } else {
                //had this initially but kept getting weird errors, helped by AI to realize I needed to use long. 
                out.append(Math.max(1L, 2L * max-sum)).append("\n");
            }
        }

        System.out.print(out);
    }
}