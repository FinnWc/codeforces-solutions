import java.io.*;
import java.util.*;

public class J_Delete_Two_Elements {
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
            int[] a = new int[n];
            long sum = 0;
            long counter = 0;
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                sum += a[i];
            }
            if((2 * sum) % n != 0) {
                out.append(0).append("\n");
                continue;
            }
            long goal = (2 * sum) / n;
            HashMap<Long, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                long otherHalf = goal - a[i];
                Integer cnt = map.get(otherHalf);
                if(cnt != null) {
                    counter += cnt;
                }
                //forgot hashmaps had a getOrDefault method, looked this up
                map.put((long)a[i], map.getOrDefault((long)a[i], 0) + 1);
            }
            out.append(counter).append("\n");
        }
        System.out.print(out);
    }
}