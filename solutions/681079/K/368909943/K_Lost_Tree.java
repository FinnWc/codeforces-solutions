import java.io.*;
import java.util.*;

public class K_Lost_Tree {
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

    static FastScanner fs = new FastScanner();

    //had some help from AI to figure out to work with the IO for this interactive problem 
    static int[] query(int r, int n) {
        System.out.println("? " + r);
        System.out.flush();

        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = fs.nextInt();
        }
        return d;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        int[] first = query(1, n);
        //also used an AI hint to figure out that the best way to figure this out was by using a strategy involving parity.
        //My original methods did not work.
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<int[]> edges = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (first[i] % 2 == 0) even.add(i);
            else odd.add(i);

            if (first[i] == 1) {
                edges.add(new int[]{1, i});
            }
        }

        //some ai hints also helped me find this. I found this to be a very difficult problem, tried a few different methods but nothing I tried
        //was working. I've never seen or attempted an interactive problem like this so had to use some AI to help me figure it out. 
        ArrayList<Integer> use = (even.size() <= odd.size()) ? even : odd;

        for (int u : use) {
            if (u == 1) continue;

            int[] dist = query(u, n);
            for (int v = 1; v <= n; v++) {
                if (dist[v] == 1) {
                    edges.add(new int[]{u, v});
                }
            }
        }
        //used another hint to realize a set was the best way to keep track of these seen vals
        System.out.println("!");
        HashSet<String> seen = new HashSet<>();
        for (int[] e : edges) {
            int a = Math.min(e[0], e[1]);
            int b = Math.max(e[0], e[1]);
            String key = a + " " + b;
            if (!seen.contains(key)) {
                seen.add(key);
                System.out.println(a + " " + b);
            }
        }
        System.out.flush();
    }
}