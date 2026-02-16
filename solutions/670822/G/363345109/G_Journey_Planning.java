import java.io.*;
import java.util.*;

public class G_Journey_Planning {
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
        int[] b = new int[n];

        //idea for difference calculation and hashmap came from GPT
        HashMap<Integer, Long> sumMap = new HashMap<>();
        long sum = 0;
        
        for(int i = 0; i < n; i++) {
            b[i] = fs.nextInt();
            int difference = (i+1) - b[i];
            long newSum = sumMap.getOrDefault(difference, 0L) + b[i];
            sumMap.put(difference,newSum);
            if(newSum > sum) {
                sum = newSum;
            }
        }
        System.out.println(sum);

    
    }
}