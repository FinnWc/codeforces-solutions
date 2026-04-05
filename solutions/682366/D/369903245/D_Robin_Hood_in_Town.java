import java.io.*;
import java.util.*;

public class D_Robin_Hood_in_Town {
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
            for(int i = 0; i < n; i++) { 
                a[i] = fs.nextInt(); 
                sum += a[i];
            }

            Arrays.sort(a);
            if(n <= 2) {
                out.append("-1\n");
                continue;
            }
            long middleVal = a[n/2];
            //i had a while loop here, it worked but I knew there was a better equation-based answer, so ended up 
            //figuring out the below after a few hints from ai.
            long x = Math.max(0,2 * n * middleVal - sum + 1);
            out.append(x).append("\n");

        }

        System.out.print(out);
    }
}