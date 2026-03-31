import java.io.*;
import java.util.*;

public class A_Journey {
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
            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();
            int rotation = a+b+c;
            int mainVal = n/rotation;
            int remainder = n % rotation;
            int numDays = mainVal * 3;
            if(remainder == 0) {
                out.append(numDays);
            } else if(remainder <= a) {
                out.append(numDays + 1);
            } else if(remainder <= a+b) {
                out.append(numDays + 2);
            } else {
                out.append(numDays + 3);
            }
            out.append("\n");
        }           
        System.out.print(out);
    }
}