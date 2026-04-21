import java.io.*;
import java.util.*;

public class A_Vlad_and_Shapes {
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
            int n = fs.nextInt();
            int[] numOnes = new int[n];
            Arrays.fill(numOnes, 0);
            
            for(int i = 0; i < n; i++) {
                String row = fs.next();
                for(char c : row.toCharArray()) {
                    if(c == '1') {
                        numOnes[i]++;
                    }
                }
            }


            for(int i = 0; i < n; i++) {
                if(numOnes[i] != 0 && numOnes[i+1] != 0) {
                    if(numOnes[i] == numOnes[i+1]) {
                        out.append("SQUARE\n");
                        break;
                    } else {
                        out.append("TRIANGLE\n");
                        break;
                    }
                }
            }
            
            
        }

        System.out.print(out);
    }
}