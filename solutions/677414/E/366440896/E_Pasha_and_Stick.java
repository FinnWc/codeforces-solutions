import java.io.*;
import java.util.*;

public class E_Pasha_and_Stick {
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

        int n = fs.nextInt();
        if(n % 2 == 1) {
            out.append("0");
        } else {
            int target = n/2;
            int total = 0;
            for(int x = 1; x <= target; x++) {
                int y = target-x;
                if(x < y) {
                    total++;
                }
            }
            out.append(total + "\n");
        }

        System.out.print(out);
    }
}