import java.io.*;
import java.util.*;

public class AReposts {
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

    static int dfs(String user, HashMap<String, ArrayList<String>> adj) {
        if(!adj.containsKey(user) || adj.get(user).isEmpty()) {
            return 1;
        }
        int longest = 0;
        for(String neighbor : adj.get(user)) {
            int length = dfs(neighbor, adj);
            longest = Math.max(longest, length);
        }
        return 1+longest;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        HashMap<String, ArrayList<String>> adj = new HashMap<>();
        String user1, user2;
        for(int i = 0; i < n; i++) {
            user1 = fs.next().toLowerCase();
            fs.next();
            user2 = fs.next().toLowerCase();
            adj.putIfAbsent(user2, new ArrayList<>());
            adj.get(user2).add(user1);
        }
        int result = dfs("polycarp", adj);
        out.append(result);


        System.out.print(out);
    }
}