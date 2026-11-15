
import java.io.*;
import java.util.*;

public class DCopyingData {
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

    //found this problem to, again, be very difficult. I tried my best to implement the segment
    //tree by myself but spent far too long on this problem trying to get it to work with insufficient logic. 
    //didn't realize lazy propogation was the key to understanding the problem. Used AI hints and help to write/understand
    //the solution
    static class SegmentTree {
        int[] tree;
        int[] a, b;
        int n;
        final int NONE = Integer.MAX_VALUE;

        SegmentTree(int[] a, int[] b, int n) {
            this.a = a;
            this.b = b;
            this.n = n;
            tree = new int[4 * n];
            Arrays.fill(tree, NONE);
        }

        void push(int node) {
            if (tree[node] == NONE) return;

            tree[node * 2] = tree[node];
            tree[node * 2 + 1] = tree[node];

            tree[node] = NONE;
        }

        void update(int node, int l, int r,
                    int ql, int qr, int offset) {

            if (qr < l || r < ql) return;

            if (ql <= l && r <= qr) {
                tree[node] = offset;
                return;
            }

            push(node);
            int mid = (l + r) / 2;
            update(node * 2, l, mid, ql, qr, offset);
            update(node * 2 + 1, mid + 1, r, ql, qr, offset);
        }

        int query(int node, int l, int r, int pos) {
            if (tree[node] != NONE) {
                return a[pos + tree[node]];
            }
            if (l == r) {
                return b[pos];
            }
            int mid = (l + r) / 2;
            if (pos <= mid) {
                return query(node * 2, l, mid, pos);
            } else {
                return query(node * 2 + 1, mid + 1, r, pos);
            }
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = fs.nextInt();
        }
        SegmentTree seg = new SegmentTree(a, b, n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int type = fs.nextInt();

            if (type == 1) {
                int x = fs.nextInt() - 1;
                int y = fs.nextInt() - 1;
                int k = fs.nextInt();
                seg.update(1, 0, n - 1, y, y + k - 1, x - y);
            } else {
                int x = fs.nextInt() - 1;
                sb.append(seg.query(1, 0, n - 1, x)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
