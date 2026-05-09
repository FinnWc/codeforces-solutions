import java.io.*;
import java.util.*;

public class APhoneDesktop {
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
            int x = fs.nextInt();
            int y = fs.nextInt();
            int numScreens = (y+1) / 2; // 1
            int numAvailableSlots = numScreens * 15 - y * 4; //2
            if(x > numAvailableSlots) {
                int total = ((x-numAvailableSlots) + 14) / 15;
                out.append(total + numScreens).append("\n");
            } else {
                out.append(numScreens).append("\n");
            }
        }
        System.out.print(out);
    }
}