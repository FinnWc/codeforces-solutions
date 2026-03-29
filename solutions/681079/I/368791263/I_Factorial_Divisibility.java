import java.io.*;
import java.util.*;

public class I_Factorial_Divisibility {
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

        int n = fs.nextInt();
        int x = fs.nextInt();
        int[] a = new int[n];
        long[] freq = new long[x+1];
        for(int i = 0; i < n; i++) { 
            a[i] = fs.nextInt(); 
            freq[a[i]]++;
        }
        //tried factorization, prefix, and a few other things I could think of. I eventually asked AI and realized that
        //you can just make a frequency array due to a rule of factorials I didn't know existed:
        boolean correct = true;
        for (int i = 1; i < x; i++) {
            if(freq[i] % (i + 1) != 0) {
                correct = false;
                break;
            }
            freq[i + 1] += freq[i] / (i + 1);
        }
        out.append(correct ? "Yes" : "No");
        System.out.print(out);
    }
}