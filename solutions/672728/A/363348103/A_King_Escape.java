import java.io.*;
import java.util.*;

public class A_King_Escape {
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
        int[] a = new int[2];
        int[] b = new int[2];
        int[] c = new int[2];
        
        a[0] = fs.nextInt();
        a[1] = fs.nextInt();
        b[0] = fs.nextInt();
        b[1] = fs.nextInt();
        c[0] = fs.nextInt();
        c[1] = fs.nextInt();
        
        if((b[0] > a[0] && a[0] > c[0]) || (b[0] < a[0] && a[0] < c[0])) {
            System.out.println("NO");
        } else if((b[1] > a[1] && a[1] > c[1]) || (b[1] < a[1] && a[1] < c[1])) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

        
        
    }
}