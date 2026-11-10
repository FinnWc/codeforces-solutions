import java.io.*;
import java.util.*;

public class ADistinctCharactersQueries {
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


    //understood the idea of the seg tree after class lecture, but went through the slides
    //and copied some of the implementation here, also used some AI to understand the bit masking
    //part of the problem and how I could store the values in the tree. Found this problem quite difficult. 
    static class segmentTree {
        int n;
        int[] tree;
        segmentTree(char[] arr) {
            n = arr.length;
            tree = new int[4*n];
            build(arr, 1, 0, n - 1);
        }

        void build(char[] arr, int node, int l, int r) {
            if (l == r) {
                tree[node] = 1 << (arr[l] - 'a');
                return;
            }
            int mid = (l+r) / 2;
            build(arr, node * 2, l, mid);
            build(arr, node * 2 + 1, mid + 1, r);
            tree[node] = tree[node * 2] | tree[node * 2 + 1];
        }

        void update(int pos, char c) {
            update(1, 0, n - 1, pos, c);
        }

        void update(int node, int l, int r, int pos, char c) {
            if (l == r) {
                tree[node] = 1 << (c - 'a');
                return;
            }

            int mid = (l + r) / 2;

            if (pos <= mid) {
                update(node * 2, l, mid, pos, c);
            } else {
                update(node * 2 + 1, mid + 1, r, pos, c);
            }

            tree[node] = tree[node * 2] | tree[node * 2 + 1];
        }

        int query(int left, int right) {
            return query(1, 0, n - 1, left, right);
        }

        int query(int node, int l, int r, int ql, int qr) {

            if (r < ql || l > qr) {
                return 0;
            }

            if (ql <= l && r <= qr) {
                return tree[node];
            }

            int mid = (l + r) / 2;

            int a = query(node * 2, l, mid, ql, qr);
            int b = query(node * 2 + 1, mid + 1, r, ql, qr);

            return a | b;
        }
    }

    

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        String s = fs.next();
        char[] sChar = s.toCharArray();
        segmentTree seg = new segmentTree(sChar);
        int q = fs.nextInt();
        for(int i = 0; i < q; i++) {
            int type = fs.nextInt();
            if(type == 1) {
                int pos = fs.nextInt()-1;
                char c = fs.next().charAt(0);
                sChar[pos] = c;
                seg.update(pos, c);
            } else {
                int l = fs.nextInt()-1;
                int r = fs.nextInt()-1;
                int mask = seg.query(l, r);
                int ans = Integer.bitCount(mask);
                out.append(ans).append("\n");
            }
        }
        System.out.print(out);
    }
}