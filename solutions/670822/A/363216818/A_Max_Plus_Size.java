import java.io.*;
import java.util.*;

public class A_Max_Plus_Size {
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
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            
            int maxEvenNum = Integer.MIN_VALUE;
            int maxOddNum = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                if(i % 2 == 0) {
                    maxEvenNum = Math.max(maxEvenNum, a[i]);
                } else {
                    maxOddNum = Math.max(maxOddNum, a[i]);
                }
            }
            int maxEvenScore, maxOddScore;
            if(n % 2 == 0) {
                maxEvenScore = maxEvenNum + n/2;
                maxOddScore = maxOddNum + n/2;
            } else {
                maxEvenScore = maxEvenNum + (n/2)+1;
                maxOddScore = maxOddNum + n/2;
            }
            if(maxEvenScore > maxOddScore) {
                out.append(maxEvenScore + "\n");
            } else {
                out.append(maxOddScore + "\n");
            }
        }

        System.out.print(out);
    }
} 