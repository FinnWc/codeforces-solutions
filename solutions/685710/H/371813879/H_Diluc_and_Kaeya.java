import java.io.*;
import java.util.*;

public class H_Diluc_and_Kaeya {
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

    static int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while(t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            HashMap<String, Integer> map = new HashMap<>();
            int ds = 0;
            int ks = 0;
            int gcd;
            for(int i = 0; i < n; i++) {
                //AI helped me realize I had accidentally used a lowercase 'd' instead of uppercase
                if(s.charAt(i) == 'D') {
                    ds++;
                } else {
                    ks++;
                }
                gcd = gcd(ds,ks);
                map.put((ds/gcd) + "/" + (ks/gcd), map.getOrDefault((ds/gcd) + "/" + (ks/gcd), 0) + 1);
                out.append(map.get((ds/gcd) + "/" + (ks/gcd)) + " ");
            }
            out.append("\n");
        }

        System.out.print(out);
    }
}