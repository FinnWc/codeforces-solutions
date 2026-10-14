import java.io.*;
import java.util.*;

public class BMashaAndABeautifulTree {
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
        while(t-- > 0) {
            int m = fs.nextInt();
            int[] p = new int[m];
            for(int i = 0; i < m; i++) {
                p[i] = fs.nextInt();
            }
            if(m==1) {
                out.append(0).append("\n");
                continue;
            }
            int mid, end;
            int count = 0;
            for(int i = 2; i <= m; i *= 2) {
                for(int j = 0; j < m; j=j+i) {
                    mid = j + i/2;
                    end = j+i;
                    if(p[mid-1] < p[mid]) {
                        continue;
                    } else if(p[end-1] < p[j]) {
                        //got a little bit boggled at this step, kept messing up my indices, AI helped a little here
                        for(int k = 0; k < i/2; k++) {
                            int temp = p[j+k];
                            p[j+k] = p[mid+k];
                            p[mid+k] = temp;
                        }
                        count++;
                    } else {
                        count = -1;
                        break;
                    }
                }
                if(count == -1) {
                    break;
                }
            }
            out.append(count).append("\n");
        }
        System.out.print(out);
    }
}