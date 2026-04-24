import java.io.*;
import java.util.*;

public class A_Parallel_Projection {
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
            int w = fs.nextInt();
            int d = fs.nextInt();
            int h = fs.nextInt();
            int a = fs.nextInt();
            int b = fs.nextInt();
            int f = fs.nextInt();
            int g = fs.nextInt();
            int leftWall = a+h+f+Math.abs(b-g);
            int topWall = (d-g)+h+(d-b)+Math.abs(a-f);
            int rightWall = (w-f)+h+(w-a)+Math.abs(b-g);
            int frontWall = g+h+b+Math.abs(a-f);
            int dist = Math.min(Math.min(frontWall,rightWall),Math.min(topWall,leftWall));
            out.append(dist + "\n");
        }   

        System.out.print(out);
    }
}