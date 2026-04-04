import java.io.*;
import java.util.*;

public class B_Sushi_for_Two {
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
        int[] a = new int[n];
        for(int i = 0; i < n; i++) { a[i] = fs.nextInt(); }

        int[] ans = new int[n];
        int counter = 1;
        int index = 0;
        for(int i = 1; i < n; i++) {
            if(a[i] == a[i-1]) {
                counter++;
            } else {
                ans[index++] = counter;
                counter = 1;
            }
        }
        ans[index++] = counter;
        int returnVal = 0;
        for(int i = 0; i < index-1; i++) {
            returnVal = Math.max(returnVal, 2 * Math.min(ans[i], ans[i+1]));
        }
        out.append(returnVal);
        System.out.print(out);
    }
}