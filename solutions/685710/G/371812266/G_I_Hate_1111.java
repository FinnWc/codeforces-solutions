import java.io.*;
import java.util.*;

public class G_I_Hate_1111 {
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
            int x = fs.nextInt();
            boolean possible = false;

            //needed some help with the logic here. I still am pretty weak with some of these math problems. Worked through this one with AI.
            for (int a = 0; a <= 10; a++) {
                if (111 * a > x) break;
                int remaining = x - 111 * a;
                if (remaining % 11 == 0) {
                    possible = true;
                    break;
                }
            }
            if(possible) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }


        }

        System.out.print(out);
    }
}