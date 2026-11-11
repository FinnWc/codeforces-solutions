import java.io.*;
import java.util.*;

public class BXeniaAndBitOperations {
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

    //wrote much more of this by myself/copying some of the boilerplate from the previous problem
    //still needed a couple AI hints to figure out and fix bugs but getting easier. 

    static class SegmentTree {
        int[] tree;
        SegmentTree(int[] a) {
            int size = a.length;
            tree = new int[4*size];
            int n = Integer.numberOfTrailingZeros(size);
            boolean rootOr = (n%2==1);
            build(1,0,size-1,a,rootOr);
        }

        void build(int node, int left, int right, int[] a, boolean useOr) {
            if(left == right) {
                tree[node] = a[left];
                return;
            }
            int mid = (left + right) / 2;
            build(node*2,left,mid,a,!useOr);
            build(node*2+1,mid+1,right,a,!useOr);
            if(useOr) {
                tree[node] = tree[node*2] | tree[node*2+1];
            } else {
                tree[node] = tree[node*2] ^ tree[node*2+1];
            }
        }

        void update(int node, int left, int right,
                    int pos, int value, boolean useOr) {
            if(left == right) {
                tree[node] = value;
                return;
            }

            int mid = (left + right) / 2;
            if(pos <= mid) {
                update(node * 2, left, mid, pos, value, !useOr);
            } else {
                update(node * 2 + 1, mid + 1, right, pos, value, !useOr);
            }

            if (useOr) {
                tree[node] = tree[node * 2] | tree[node * 2 + 1];
            } else {
                tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
            }
        }

        int answer() {
            return tree[1];
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        int m = fs.nextInt();
        int size = 1 << n;
        int[] a = new int[size];
        for(int i = 0; i < size; i++) {
            a[i] = fs.nextInt();
        }

        SegmentTree seg = new SegmentTree(a);
        boolean rootOr = (n%2==1);
        for(int i = 0; i < m; i++) {
            int p = fs.nextInt()-1;
            int b = fs.nextInt();
            seg.update(1, 0, size - 1, p, b, rootOr);
            out.append(seg.answer()).append('\n');
        }

        System.out.print(out);
    }
}