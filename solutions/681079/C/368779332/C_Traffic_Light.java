import java.io.*;
import java.util.*;

public class C_Traffic_Light {
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
            String c = fs.next();
            String lights = fs.next();
            String wrap = lights + lights;
            if(c.equals("g")) {
                out.append(0 + "\n");
                continue;
            }
            int currentDistance = -1;
            int ans = 0;
            for(int i = wrap.length()-1; i >= 0; i--) {
                if(wrap.charAt(i) == 'g') {
                    currentDistance = i;   
                }
                if(wrap.charAt(i) == c.charAt(0) && i < n) {
                    ans = Math.max(ans, currentDistance-i);
                }
                
            }
            out.append(ans + "\n");
        }
        System.out.print(out);
    }
}
