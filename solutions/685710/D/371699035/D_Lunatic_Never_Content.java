import java.io.*;
import java.util.*;

public class D_Lunatic_Never_Content {
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
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            //one small hint from ai just to realize that it was a gcd problem but wrote everything myself 
            int p = n-1;
            int q = 0;
            boolean allEq = true;
            while(q < p) {
                if(a[q++] != a[p--]) {
                    allEq = false;
                    break;
                }
            }
            if(allEq) {
                out.append(0 + "\n");
                continue;
            }
            int[] dif = new int[n/2];
            p = n-1;
            q = 0;
            int index = 0;
            while(q < p) {
                dif[index++] = Math.abs(a[q++]-a[p--]);
            }
            int gcd = arrayGcd(dif);
            out.append(gcd + "\n");
        }

        System.out.print(out);
    }
}