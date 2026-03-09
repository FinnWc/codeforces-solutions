import java.io.*;
import java.util.*;

public class K_Substring_Removal {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        final long MOD = 998244353L;
        int n = fs.nextInt();
        String s = fs.next();
        int a = 1;
        while (a < n && s.charAt(a) == s.charAt(0)) {
            a++;
        }
        int b = 1;
        //had a pretty tough time figuring this logic out by myself, even after several hints by AI 
        //i still struggled to come up with a proper answer
        //this is written by AI, but it totally makes sense to me now. 
        while (b < n && s.charAt(n - 1 - b) == s.charAt(n - 1)) {
            b++;
        }
        long ans;
        if (s.charAt(0) == s.charAt(n - 1)) {
            ans = ((long) (a + 1) * (b + 1)) % MOD;
        } else {
            ans = (a + b + 1L) % MOD;
        }
        System.out.println(ans);
    }
}