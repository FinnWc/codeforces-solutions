import java.io.*;
import java.util.*;

public class H_Rings {
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
            String binary = fs.next();
            boolean onesOnly = true;
            for(int i = 0; i < n; i++) {
                char c = binary.charAt(i);
                //had a little help from some AI hints in order to figure out exactly what an optimal set of strings were
                if(c == '0' && i < (n + 1) / 2) {
                    //AI also helped me debug my indexing mistake
                    out.append((1+i) + " " + n + " " + (2+i) + " " + n);
                    onesOnly = false;
                    break;
                } else if(c=='0'){
                    out.append(1 + " " + (i+1) + " " + 1 + " " + i);
                    onesOnly = false;
                    break;
                } 
            }
            if(onesOnly) {
                out.append(1 + " " + (n-1) + " " + 2 + " " + n);
            }
            out.append("\n");
        }
        System.out.print(out);
    }
}