import java.io.*;
import java.util.*;

public class S_Sum_of_XOR_Functions {
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

    static final long MOD = 998244353L;

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        int[] a = new int[n+1];
        for(int i = 1; i <= n; i++) { a[i] = fs.nextInt(); }
        //AI hint helped me realize that this could be converted into a prefix problem:
        long ans = 0;
        for(int i = 0; i <= 30; i++) {
            long[] count = new long[2];
            long[] sumIndex = new long[2];
            count[0] = 1;
            sumIndex[0] = 0;
            int prefixXor = 0;
            long totalForThisBit = 0;
            //most of this is code that I worked through with AI. This problem was too hard for me to understand by myself
            //so instead of avoiding it I wanted to see how much I could learn by getting some AI help. I understand how bitwise XOR works now
            //and the purpose of the problem and solution
            for(int j = 1; j <= n; j++) {
                prefixXor ^= a[j];
                int currentBit = (prefixXor >> i) & 1;
                int oppositeBit = 1-currentBit;
                totalForThisBit += count[oppositeBit] * j - sumIndex[oppositeBit];
                totalForThisBit %= MOD;
                count[currentBit]++;
                sumIndex[currentBit] += j;
            }
            long bitValue = (1L << i) % MOD;
            ans = (ans + totalForThisBit * bitValue) % MOD;
        }
        if(ans < 0) {
            ans += MOD;
        }

        System.out.print(ans);
    }
}