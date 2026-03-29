import java.io.*;
import java.util.*;

public class B_Orac_and_Factors {
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
            int k = fs.nextInt();
            boolean justStarted = true;
            for(int i = 0; i < k; i++) {
                if(n % 2 == 0 && justStarted) {
                    n += 2 * k;
                    break;
                } else if(!(n % 2 == 0)){
                    int divisor = 0;
                    for(int j = 3; j * j <= n; j += 2) {
                        if(n % j == 0) {
                            divisor = j;
                            break;
                        }
                    }
                    if(divisor == 0) {
                        n += n;
                    } else {
                        n += divisor;
                    }
                    justStarted = false;
                } else {
                    n += 2*(k-1);
                    break;
                }
            }
            out.append(n + "\n");
        }

        System.out.print(out);
    }
}