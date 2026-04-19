import java.io.*;
import java.util.*;

public class J_Trailing_Loves_or_L_oeufs {
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

        long n = fs.nextLong();
        long b = fs.nextLong();
        //couldn't figure this one out on my own so walked through it over the span of 30 or so minutes with the help of AI
        //completely understand it now. 
        HashMap<Long,Long> pf = new HashMap<>();
        while(b % 2 == 0) {
            pf.put(2L,pf.getOrDefault(2L, 0L)+1);
            b /= 2;
        }
        for(long i = 3; i * i <= b; i += 2) {
            while(b%i == 0) {
                pf.put((long)i,pf.getOrDefault((long)i, 0L)+1);
                b /= i;
            }
        }
        if(b > 1) {
            pf.put((long)b,pf.getOrDefault((long)b, 0L)+1);
        }
        long ans = Long.MAX_VALUE;
        for (Map.Entry<Long,Long> entry : pf.entrySet()) {
            long p = entry.getKey();
            long need = entry.getValue();
            long have = 0;
            long temp = n;
            while(temp > 0) {
                temp /= p;
                have += temp;
            }
            ans = Math.min(ans, have / need);
        }
        out.append(ans);
        System.out.print(out);
    }
}