import java.io.*;
import java.util.*;

public class APotionsEasyVersion {
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
        //Ai hint nudged me in the direction of PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        long sum = 0;
        for(int i = 0; i < n; i++) {
            pq.add(a[i]);
            sum += a[i];
            if(sum < 0) {
                sum -= pq.poll();
            }
        }
        System.out.print(pq.size());
    }
}