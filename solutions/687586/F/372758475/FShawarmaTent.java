import java.io.*;
import java.util.*;

public class FShawarmaTent {
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
        int sx = fs.nextInt();
        int sy = fs.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = fs.nextInt();
            y[i] = fs.nextInt();
        }
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < n; i++) {
            int tx = x[i];
            int ty = y[i];
            if(tx > sx) {
                right++;
            } 
            if(tx < sx) {
                left++;
            }
            if(ty > sy) {
                up++;
            } 
            if(ty < sy) {
                down++;
            }
        }
        int largest = Math.max(Math.max(up,down),Math.max(left,right));
        if(up == largest) {
            out.append(up + "\n").append(sx + " " + ++sy);
        } else if(down == largest) {
            out.append(down + "\n").append(sx + " " + --sy);
        } else if(left == largest) {
            out.append(left + "\n").append(--sx + " " + sy);
        } else if(right == largest) {
            out.append(right + "\n").append(++sx + " " + sy);
        }
        System.out.print(out);
    }
}