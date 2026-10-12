import java.io.*;
import java.util.*;

public class DIdentifyTheOperations {
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

        //tried arraylist first, realized it was too slow then tried to implement a solution
        //using treeset but it was too difficult for me to figure out with no AI assistance/google.
        //AI walked me through the doubly-linked list solution that I didn't think of. Relearned how to use 
        //doubly linked lists
        int t = fs.nextInt();
        long mod = 998244353L;
        while(t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] a = new int[n];
            int[] b = new int[k];
            int[] pos = new int[n + 1];
            int[] left = new int[n];
            int[] right = new int[n];
            boolean[] needed = new boolean[n + 1];
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                pos[a[i]] = i;
                left[i] = i - 1;
                right[i] = i + 1;
            }
            for(int i = 0; i < k; i++) {
                b[i] = fs.nextInt();
                needed[b[i]] = true;
            }
            long ans = 1;
            for(int i = 0; i < k; i++) {
                int p = pos[b[i]];
                int l = left[p];
                int r = right[p];
                boolean canLeft = l >= 0 && !needed[a[l]];
                boolean canRight = r < n && !needed[a[r]];
                int ways = 0;
                if(canLeft) ways++;
                if(canRight) ways++;
                if(ways == 0) {
                    ans = 0;
                    break;
                }
                ans = (ans * ways) % mod;
                int remove = canLeft ? l : r;
                int prev = left[remove];
                int next = right[remove];
                if(prev >= 0) right[prev] = next;
                if(next < n) left[next] = prev;
                needed[b[i]] = false;
            }
            out.append(ans).append("\n");
        }
        System.out.print(out);
    }
}