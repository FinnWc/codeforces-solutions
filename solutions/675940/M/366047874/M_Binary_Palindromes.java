import java.io.*;
import java.util.*;

public class M_Binary_Palindromes {
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
        while (t-- > 0) {
            int n = fs.nextInt();
            int totalOnes = 0;
            boolean hasOddLen = false;
            for (int i = 0; i < n; i++) {
                String s = fs.next();
                //kept solving this one wrong as well but AI helped me realize the logic below and that 
                //it just depends on the odd/even length
                if ((s.length() & 1) == 1) {
                    hasOddLen = true;
                }
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '1') totalOnes++;
                }
            }
            int ans;
            if (hasOddLen) {
                ans = n;
            } else {
                ans = (totalOnes % 2 == 0) ? n : (n - 1);
            }
            out.append(ans).append('\n');
        }
        System.out.print(out);
    }
}