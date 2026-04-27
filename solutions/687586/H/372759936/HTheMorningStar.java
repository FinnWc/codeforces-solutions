import java.io.*;
import java.util.*;

public class HTheMorningStar {
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
            //was a little pressed for time on this one so gave what I thought the general
            //idea for the solution was to AI and it helped me refine my idea, then I wrote the code myself.
            int n = fs.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for(int i = 0; i < n; i++) {
                x[i] = fs.nextInt();
                y[i] = fs.nextInt();
            }
            HashMap<Integer,Integer> xmap = new HashMap<>();
            HashMap<Integer,Integer> ymap = new HashMap<>();
            HashMap<Integer,Integer> diag1 = new HashMap<>();
            HashMap<Integer,Integer> diag2 = new HashMap<>();
            for(int i = 0; i < n; i++) {
                xmap.put(x[i],xmap.getOrDefault(x[i],0) + 1);
                ymap.put(y[i],ymap.getOrDefault(y[i],0) + 1);
                diag1.put(x[i]-y[i],diag1.getOrDefault(x[i]-y[i],0) + 1);
                diag2.put(x[i]+y[i],diag2.getOrDefault(x[i]+y[i],0) + 1);
            }
            long total = 0;
            for(int val : xmap.values()) {
                total += 1L * val * (val - 1);
            }
            for(int val : ymap.values()) {
                total += 1L * val * (val - 1);
            }
            for(int val : diag1.values()) {
                total += 1L * val * (val - 1);
            }
            for(int val : diag2.values()) {
                total += 1L * val * (val - 1);
            }
            out.append(total + "\n");
        }

        System.out.print(out);
    }
}