import java.io.*;
import java.util.*;

public class CSecretPasswords {
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

    static int[] parent = new int[26];
    static int[] size = new int[26];

    static int find(int a) {
        if(parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;
        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        
        //tried for a while to solve this via a node/graph approach, connecting passwords that share letters
        //however this wasn't working so I had AI walk me through the DSU approach
        int n = fs.nextInt();
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        boolean[] used = new boolean[26];
        for (int i = 0; i < n; i++) {
            String s = fs.next();
            int first = s.charAt(0) - 'a';
            for (int j = 0; j < s.length(); j++) {
                int curr = s.charAt(j) - 'a';
                used[curr] = true;
                union(first, curr);
            }
        }
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (used[i] && find(i) == i) {
                answer++;
            }
        }
        System.out.println(answer);
        

        System.out.print(out);
    }
}