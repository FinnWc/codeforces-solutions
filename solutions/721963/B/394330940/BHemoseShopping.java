import java.io.*;
import java.util.*;

public class BHemoseShopping {
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
            int x = fs.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            int[] aSorted = a.clone();
            Arrays.sort(aSorted);
            boolean flag = true;
            for(int i = 0; i < n; i++) {
                //AI hint helped me recognize the error I had with this pattern conditional
                if(i < x && n - 1 - i < x && a[i] != aSorted[i]) {
                    flag = false;
                }
            }
            if(flag) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }
            
        }

        System.out.print(out);
    }
}