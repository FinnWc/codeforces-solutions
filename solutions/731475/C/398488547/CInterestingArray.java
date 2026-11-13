import java.io.*;
import java.util.*;

public class CInterestingArray {


    //this problem still was too hard for me to figure out on my own. I had lots of
    //difficulty completing it myself, so watched video explanation along with help from AI.
    //https://www.youtube.com/watch?v=BC8Isulsk6A


    static class SegmentTree {
        int[] tree, lazy;
        int n;
        static final int ALL_ONES = (1 << 30) - 1;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n + 5];
            lazy = new int[4 * n + 5];
        }

        void apply(int node, int value) {
            tree[node] |= value;
            lazy[node] |= value;
        }

        void push(int node) {
            if (lazy[node] != 0) {
                apply(node * 2, lazy[node]);
                apply(node * 2 + 1, lazy[node]);
                lazy[node] = 0;
            }
        }

        void update(int node, int start, int end,
                    int l, int r, int value) {
            if (r < start || end < l) return;

            if (l <= start && end <= r) {
                apply(node, value);
                return;
            }

            push(node);

            int mid = (start + end) / 2;

            update(node * 2, start, mid, l, r, value);
            update(node * 2 + 1, mid + 1, end, l, r, value);

            tree[node] = tree[node * 2] & tree[node * 2 + 1];
        }

        int query(int node, int start, int end,
                  int l, int r) {
            if (r < start || end < l) return ALL_ONES;

            if (l <= start && end <= r) return tree[node];

            push(node);

            int mid = (start + end) / 2;

            return query(node * 2, start, mid, l, r)
                 & query(node * 2 + 1, mid + 1, end, l, r);
        }

        void collect(int node, int start, int end, int[] a) {
            if (start == end) {
                a[start] = tree[node];
                return;
            }

            push(node);
            int mid = (start + end) / 2;

            collect(node * 2, start, mid, a);
            collect(node * 2 + 1, mid + 1, end, a);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] left = new int[m];
        int[] right = new int[m];
        int[] q = new int[m];

        SegmentTree seg = new SegmentTree(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            left[i] = Integer.parseInt(st.nextToken());
            right[i] = Integer.parseInt(st.nextToken());
            q[i] = Integer.parseInt(st.nextToken());

            seg.update(1, 1, n, left[i], right[i], q[i]);
        }

        for (int i = 0; i < m; i++) {
            int result = seg.query(1, 1, n, left[i], right[i]);

            if (result != q[i]) {
                System.out.println("NO");
                return;
            }
        }

        int[] a = new int[n + 1];
        seg.collect(1, 1, n, a);

        StringBuilder sb = new StringBuilder();
        sb.append("YES\n");

        for (int i = 1; i <= n; i++) {
            if (i > 1) sb.append(' ');
            sb.append(a[i]);
        }

        System.out.println(sb);
    }
}

