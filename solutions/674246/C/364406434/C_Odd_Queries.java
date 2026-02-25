import java.io.*;
import java.util.*;

public class C_Odd_Queries {
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
            int q = fs.nextInt();
            int[] a = new int[n];
            int ogSum = 0;
            int[] allSums = new int[n+1];
            allSums[0] = 0;
            for(int i = 0; i < n; i++) { 
                a[i] = fs.nextInt();
                allSums[i+1] = allSums[i] + a[i];
                ogSum += a[i];
            }
            for(int i = 0; i < q; i++) {
                int l = fs.nextInt()-1;
                int r = fs.nextInt()-1;
                int k = fs.nextInt();
                int newSum = allSums[r+1] - allSums[l];
                int returnVal;
                returnVal = ogSum - newSum + ((r-l+1)*k);
                if(returnVal % 2 == 0) {
                    out.append("NO\n");
                } else {
                    out.append("YES\n");
                }
            }
        }
        System.out.print(out);
    }
}