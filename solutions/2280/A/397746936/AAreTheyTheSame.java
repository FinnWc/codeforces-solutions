import java.io.*;
import java.util.*;

public class AAreTheyTheSame {
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
            int k = fs.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int numEvenA, numEvenB;
            numEvenA = 0;
            numEvenB = 0;
            boolean zeroFound = false;
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                if(a[i] % 2 ==0) {
                    numEvenA++;
                }
            }
            for(int i = 0; i < n; i++) {
                b[i] = fs.nextInt();
                if(b[i] % 2 == 0) {
                    numEvenB++;
                }
            }
            int numOddA = n-numEvenA;
            int numOddB = n-numEvenB;
            if(numEvenA == numEvenB) {
                out.append("YES\n");
                continue;
            } else if(k % 2 == 1 && numOddA < numOddB) {//not same number of even/odds
                out.append("YES\n");
                continue;
            } else if(k % 2 == 0 && numEvenA < numEvenB){
                out.append("YES\n");
                continue;
            } else {
                out.append("NO\n");
                continue;
            }

        }

        System.out.print(out);
    }
}