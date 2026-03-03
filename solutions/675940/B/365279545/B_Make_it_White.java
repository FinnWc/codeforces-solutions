import java.io.*;
import java.util.*;

public class B_Make_it_White {
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
            char[] sChar = s.toCharArray();
            int firstBlack= -1, lastBlack = -1;
            for(int i = 0; i < n; i++) {
                if(firstBlack == -1 && sChar[i] == 'B') {
                    firstBlack = i;
                }
            }
            for(int i = n-1; i >= 0; i--) {
                if(lastBlack == -1 && sChar[i] == 'B') {
                    lastBlack = i;
                }
            }
            out.append(lastBlack - firstBlack + 1).append("\n"); 
        }

        System.out.print(out);
    }
}