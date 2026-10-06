import java.io.*;
import java.util.*;

public class AEqualOrNotEqual {
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
            int counter = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'N') {
                    counter++;
                }
            }
            if(counter == 1) {
                out.append("NO\n");
            } else {
                out.append("YES\n");
            }
        }
        System.out.print(out);
    }
}