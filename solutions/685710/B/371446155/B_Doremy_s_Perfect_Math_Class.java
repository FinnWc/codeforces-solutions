import java.io.*;
import java.util.*;

public class B_Doremy_s_Perfect_Math_Class {
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
    
    //https://www.youtube.com/watch?v=BWah400Cu_A to remember how to write gcd algo
    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    static int arrayGcd(int[] arr) {
        int ans = arr[0];
        for(int val : arr) {
            ans = gcd(ans, val);
        }
        return ans;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while(t-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                max = Math.max(max, a[i]);
            }   
            int ans = arrayGcd(a);
            out.append((max/ans) + "\n");

        }

        System.out.print(out);
    }
}