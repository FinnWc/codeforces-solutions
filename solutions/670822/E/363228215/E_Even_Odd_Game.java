import java.io.*;
import java.util.*;

public class E_Even_Odd_Game {
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
            Integer[] a = new Integer[n];
            long alicePoints = 0;
            long bobPoints = 0;
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            Arrays.sort(a, Collections.reverseOrder());
            for(int i = 0; i < n; i++) {
                if(i % 2 == 0) {
                    if(a[i] % 2 == 0) {
                        alicePoints += a[i];
                    }
                } else {
                    if(a[i] % 2 != 0) {
                        bobPoints += a[i];
                    }
                }
            }
            if(alicePoints > bobPoints) {
                out.append("Alice\n");
            } else if(alicePoints < bobPoints) {
                out.append("Bob\n");
            } else {
                out.append("Tie\n");
            }
        }
        System.out.print(out);
    }
}