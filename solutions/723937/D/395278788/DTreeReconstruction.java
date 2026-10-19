
import java.io.*;
import java.util.*;

public class DTreeReconstruction {
    static class FastScanner {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int[] count = new int[n + 1];
        boolean[] used = new boolean[n + 1];

        // Was unable to solve this problem on my own after an hour or so, AI walked me through it
        for (int i = 0; i < n - 1; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();

            if (b != n) {
                System.out.println("NO");
                return;
            }

            count[a]++;
            used[a] = true;
        }

        ArrayList<Integer> unused = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (!used[i]) {
                unused.add(i);
            }
        }

        int ptr = 0;
        StringBuilder ans = new StringBuilder();
        for (int a = 1; a < n; a++) {
            if (count[a] == 0) continue;

            int current = n;

            for (int j = 1; j < count[a]; j++) {
                if (ptr >= unused.size()
                        || unused.get(ptr) >= a) {
                    System.out.println("NO");
                    return;
                }

                int extra = unused.get(ptr++);
                ans.append(current).append(" ")
                   .append(extra).append("\n");

                current = extra;
            }

            ans.append(current).append(" ")
               .append(a).append("\n");
        }

        System.out.println("YES");
        System.out.print(ans);
    }
}
