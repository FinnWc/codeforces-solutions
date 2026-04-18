import java.io.*;
import java.util.*;

public class E_Prefix_Sum_Primes {
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
        int one = 0;
        int two = 0;
        //ai helped me realize I was on the right track, but needed to slightly fix structure:
        for(int i = 0; i < n; i++) { 
            a[i] = fs.nextInt(); 
            if(a[i] == 1) {
                one++;
            } else {
                two++;
            }
        }
        if(one >= 1 && two >= 1) {
            out.append("2 1 ");
            one--;
            two--;
        }
        while(two-- > 0) {
            out.append(2 + " ");
        }
        while(one-- > 0) {
            out.append(1 + " ");
        }
    
        System.out.print(out);
    }
}