import java.io.*;
import java.util.*;

public class CMenorah {
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
            String a = fs.next();
            String b = fs.next();
            char[] aChar = a.toCharArray();
            char[] bChar = b.toCharArray();
            int numOnesA = 0;
            int numOnesB = 0;
            int dif = 0;
            for(int i = 0; i < n; i++) {
                if(aChar[i] == '1') {
                    numOnesA++;
                }
                if(bChar[i] == '1') {
                    numOnesB++;
                }
                if(aChar[i] != bChar[i]) {
                    dif++;
                }
            }//one AI hint helped me finalize the conditions
            if(numOnesA == numOnesB && numOnesB == n - numOnesA + 1) {
                out.append(Math.min(dif,n-dif)).append("\n");
            } else if(numOnesA == numOnesB) {
                out.append(dif).append("\n");
            } else if(numOnesB == n-numOnesA+1) {
                out.append(n-dif).append("\n"); 
            } else {
                out.append("-1\n");
            }
        }

        System.out.print(out);
    }
}
