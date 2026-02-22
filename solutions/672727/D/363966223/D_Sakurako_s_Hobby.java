import java.io.*;
import java.util.*;

public class D_Sakurako_s_Hobby {
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
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = fs.nextInt() - 1;
            }
            String s = fs.next();
            char[] blackWhite = s.toCharArray();
            boolean[] visited = new boolean[n];
            int[] returnArray = new int[n];
            int[] indexesOfCycle = new int[n];
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                int cur = i;
                int counter = 0;
                int blackCounter = 0;
                //as you can see by my previous attempts, my code kept hitting TLE, AI told me to try removing the boolean[].
                do {
                    indexesOfCycle[counter++] = cur;
                    visited[cur] = true;

                    if (blackWhite[cur] == '0') {
                        blackCounter++;
                    }
                    cur = p[cur];
                } while (cur != i);
                for (int j = 0; j < counter; j++) {
                    returnArray[indexesOfCycle[j]] = blackCounter;
                }
            }
            for (int i = 0; i < n; i++) {
                out.append(returnArray[i]).append(' ');
            }
            out.append('\n');
        }

        System.out.print(out);
    }
}