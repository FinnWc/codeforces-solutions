import java.io.*;
import java.util.*;

public class A_Spell_Check {
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
            String s = fs.next();
            final char[] name = {'T', 'i', 'm', 'u', 'r'};
            if(n != 5) {
                out.append("NO\n");
            } else {
                boolean good = true;
                for(char c : name) {
                    if(!s.contains(String.valueOf(c))) {
                        good = false;
                        break;
                    }
                }
                if(good) {
                    out.append("YES\n");
                } else {
                    out.append("NO\n");
                }
            }
        }

        System.out.print(out);
    }
}
