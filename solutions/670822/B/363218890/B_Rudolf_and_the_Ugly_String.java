import java.io.*;
import java.util.*;

public class B_Rudolf_and_the_Ugly_String {
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
            int counter = 0;
            int i = 0;
            while(i + 2 < n) {
                if(i+4 < n && a.startsWith("mapie",i)) {
                    counter++;
                    i += 5;
                } else if(i+2 < n && (a.startsWith("map",i) || a.startsWith("pie",i))) {
                    counter++;
                    i += 3;
                } else {
                    i++;
                }
            }
            out.append(counter + "\n");
        }   

        System.out.print(out);
    }
}