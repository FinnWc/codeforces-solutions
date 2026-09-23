import java.io.*;
import java.util.*;

public class CKuriyamaMiraiSStones {
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

        int n = fs.nextInt();
        int[] v = new int[n];
        for(int i = 0; i < n; i++) {
            v[i] = fs.nextInt();
        }
        
        int m = fs.nextInt();
        int[][] types = new int[m][3];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 3; j++) {
                types[i][j] = fs.nextInt();
            }
        }
        long[] prefixV = new long[n+1];
        prefixV[0] = 0;
        for(int i = 1; i <= n; i++) {
            prefixV[i] = prefixV[i-1] + v[i-1];
        }
        
        long[] prefixU = new long[n+1];
        Arrays.sort(v);
        prefixU[0] = 0;
        for(int i = 1; i <= n; i++) {
            prefixU[i] = prefixU[i-1] + v[i-1];
        }
        int left,right;
        long sum = 0;
        for(int i = 0; i < m; i++) {
            left = types[i][1];
            right = types[i][2];
            if(types[i][0] == 1) {
                sum = prefixV[right] - prefixV[left-1];
            }
            if(types[i][0] == 2) {
                sum = prefixU[right] - prefixU[left-1];
            }
            out.append(sum).append("\n");
        }
        System.out.print(out);
    }
}