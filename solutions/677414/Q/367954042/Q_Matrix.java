import java.io.*;
import java.util.*;

public class Q_Matrix {
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

        int a = fs.nextInt();
        String s = fs.next();
        int n = s.length();
        //this is another problem where I worked for a long time trying to figure out the solution and failed over and over again. 
        //used ai to help me walk through an actual solution and the trick of just counting the substrings makes so much sense now that I've seen it.
        int[] digits = new int[n];
        for(int i = 0; i < n; i++) {
            digits[i] = s.charAt(i) - '0';
        }
        int maxSum = 9 * n;
        long[] count = new long[maxSum + 1];
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += digits[j];
                count[sum]++;
            }
        } 
        long totalSubstrings = 1L * n * (n+1) / 2;
        long ans = 0;
        if(a == 0) {
            long zero = count[0];
            ans = 2L * zero * totalSubstrings - zero * zero;
        } else {
            //This solution is more clever than anything I feel I could've come up with. I feel like getting exposure to these harder problems
            //and having AI help me figure out some more patterns that they use has been very helpful, like in this instance. 
            for(int d = 1; 1L * d * d <= a; d++) {
                if(a % d == 0) {
                    long other = a/d;
                    if(d <= maxSum && other <= maxSum) {
                        ans += count[d] * count[(int) other];
                    }
                    if(d != other) {
                        if(other <= maxSum && d <= maxSum) {
                            ans += count[(int) other] * count[d];
                        }
                    }
                }
            }
        }


        System.out.print(ans);
    }
}