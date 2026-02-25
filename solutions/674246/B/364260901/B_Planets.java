import java.io.*;
import java.util.*;

public class B_Planets {
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
            int c = fs.nextInt();
            int[] a = new int[n];
            HashMap<Integer, Integer> orbits = new HashMap<>();
            int total = 0;
            for(int i = 0; i < n; i++) {
                int orbit = fs.nextInt();
                if(!orbits.containsKey(orbit)) {
                    orbits.put(orbit, 1);
                } else {
                    orbits.put(orbit, orbits.get(orbit) + 1);
                }
            }

            for(int value : orbits.values()) {
                if(value > c) {
                    total += c;
                } else {
                    total += value;
                }
            }
            out.append(total).append("\n");
        }

        System.out.print(out);
    }
}