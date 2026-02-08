import java.io.*;
import java.util.*;

public class Main {
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
            int counter = 0; 
            boolean sameNum = false;
            int n = fs.nextInt();
            int a[] = new int[n];
  
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            if(n == 1) {
                out.append(counter).append('\n');
                continue;
            }
            for(int i = n; i > 1; i--) {
                while(a[i-2] >= a[i-1]) {
                    if(a[i-2] == 0) {
                        out.append(-1).append('\n');
                        sameNum = true;
                        break;
                    }
                    a[i-2] = a[i-2] / 2;
                    counter++;
                }
                if(sameNum) {
                  break;
                }
            }
            if (!sameNum) {
              out.append(counter).append("\n");
            }
        }
        System.out.print(out);
    }
}