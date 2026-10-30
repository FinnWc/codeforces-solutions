import java.io.*;
import java.util.*;

public class BArrayWalk {
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
        //1 Ai hint just to fix a bug involving the z==0 case, but otherwise solved by myself
        while(t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int z = fs.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            int[] adjSum = new int[n-1];
            for(int i = 0; i < n-1; i++) {
                adjSum[i] = a[i] + a[i+1];
            }
            long maxSum = 0;
            if(z == 0) {
                for(int i = 0; i <= k; i++) {
                    maxSum += a[i];
                }
                out.append(maxSum).append("\n");
                continue;
            }

            long tempSum;

            long[] prefixSum = new long[n];
            prefixSum[0] = a[0];
            for(int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i-1] + a[i];
            }

            long[] prefixAdj = new long[n-1];
            prefixAdj[0] = adjSum[0];
            for(int i = 1; i < n-1; i++) {
                prefixAdj[i] = Math.max(prefixAdj[i-1], adjSum[i]);
            }

            for(int i = 0; i <= z && i*2 <= k; i++) {
                if(i == 0) {
                    tempSum = prefixSum[k-2*i];
                } else {
                    tempSum = prefixSum[k-2*i]+i*prefixAdj[k-2*i];
                }
                maxSum = Math.max(tempSum, maxSum);
            }
            out.append(maxSum).append("\n");
        }

        System.out.print(out);
    }
}
