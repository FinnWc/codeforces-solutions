import java.io.*;
import java.util.*;

public class B_Luntik_and_Subsequences {
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
            int[] a = new int[n];
            for(int i = 0; i < n; i++) { a[i] = fs.nextInt(); }
            int zeroCounter = 0; 
            int oneCounter = 0;
            for(int i : a) {
                if(i == 0)
                    zeroCounter++;
                else if(i == 1)
                    oneCounter++;
            }
            //figured out this shifting trick from AI 
            out.append((1L << zeroCounter) * oneCounter).append("\n");
        }
        System.out.print(out);
    }
}