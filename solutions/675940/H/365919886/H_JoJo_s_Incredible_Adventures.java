import java.io.*;
import java.util.*;

public class H_JoJo_s_Incredible_Adventures {
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
            String s = fs.next();
            String doubleS = s + s;
            int globalMax = 0;
            int currentMax = 0;
            for(int i = 0; i < doubleS.length(); i++) {
                if(doubleS.charAt(i) == '1' && currentMax < s.length()) {
                    currentMax++;
                } else if(doubleS.charAt(i) == '0') {
                    currentMax = 0;
                }
                globalMax = Math.max(currentMax, globalMax);
            }
            int n = s.length();
            //kept getting the formula slightly wrong. AI hints helped me find this: 
            if (globalMax == n) {
                out.append((long)n * n).append("\n");
            } else {
                long ans = (long)((globalMax + 1) / 2) * ((globalMax + 2) / 2);
                out.append(ans).append("\n");
            }
            
        }

        System.out.print(out);
    }
}