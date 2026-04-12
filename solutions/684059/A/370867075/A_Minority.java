import java.io.*;
import java.util.*;

public class A_Minority {
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
            String s = fs.next();
            int zeroCounter = 0;
            int oneCounter = 0;
            for(char c : s.toCharArray()) {
                if(c == '0') {
                    zeroCounter++;
                } else {
                    oneCounter++;
                }
            }
            if(zeroCounter == oneCounter) {
                out.append((oneCounter-1) + "\n");
            } else if(zeroCounter > oneCounter) {
                out.append(oneCounter + "\n");
            } else {
                out.append(zeroCounter + "\n");
            }
        }
        System.out.print(out);
    }
}