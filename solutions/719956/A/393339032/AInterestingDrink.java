import java.io.*;
import java.util.*;

public class AInterestingDrink {
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
        int[] x = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = fs.nextInt();
        }
        int q = fs.nextInt();
        int[] m = new int[q];
        for(int i = 0; i < q; i++) {
            m[i] = fs.nextInt();
        }
        
        Arrays.sort(x);
        int target, hi, low, mid;
        long sum = 0;
        for(int i = 0; i < q; i++) {
            target = m[i];
            low = 0;
            hi = n;
            while(hi > low) {
                //was doing this 0 indexed, and just having a couple issues then AI suggested to try it 1 indexed. 
                mid = low + (hi - low) / 2;
                if(x[mid] <= target ) {
                    low = mid+1;
                } else {
                    hi = mid;
                }
            }
            out.append(low).append("\n");
        }




        System.out.print(out);
    }
}