import java.io.*;
import java.util.*;

public class A_Strings_Equalization {
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

        int q = fs.nextInt();
        while(q-- > 0) {
            String s = fs.next();
            String t = fs.next();
            boolean flag = false;
            for(char c : s.toCharArray()) {
                if(t.contains(String.valueOf(c))) {
                    flag = true;
                }
            }
            if(flag) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }

        }

        System.out.print(out);
    }
}