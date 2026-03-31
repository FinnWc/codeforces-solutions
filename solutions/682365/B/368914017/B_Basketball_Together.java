import java.io.*;
import java.util.*;

public class B_Basketball_Together {
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
        long power = fs.nextInt();
        int[] players = new int[n];
        for(int i = 0; i < n; i++) { players[i] = fs.nextInt(); }
        Arrays.sort(players);
        int low = 0;
        int high = n-1;
        long counter = 0;
        while(high>=low) {
            long highestValue = players[high];
            long sum = highestValue;
            while(power>=sum) {
                if(high != low) {
                    sum += highestValue;
                    low++;
                } else {
                    break;
                }
            }
            if(power<sum) {
                counter++;
            }
            high--;
        }
        out.append(counter);
        System.out.println(out);
    }
}