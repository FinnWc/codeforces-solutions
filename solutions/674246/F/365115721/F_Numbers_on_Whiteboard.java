import java.io.*;
import java.util.*;

public class F_Numbers_on_Whiteboard {
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
            if(n == 1) {
                out.append("1\n");
                continue;
            } 
            out.append("2\n");
            int tracker = n;
            for(int i = n-1; i >= 1; i--) {
                out.append(tracker + " " + i + "\n");
                //googled how to do ceiling int divison
                tracker = (tracker + i + 1) / 2;
            }
        }

        System.out.print(out);
    }
}