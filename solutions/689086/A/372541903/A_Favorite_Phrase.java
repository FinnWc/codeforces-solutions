import java.io.*;
import java.util.*;

public class A_Favorite_Phrase {
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
        int[] arr = new int[20];
        arr[1] = 1;
        HashMap<Integer, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 20; i++) {
            sb.append("a");
            map.put(i,sb.toString());
        }
        for(int i = 2; i < arr.length-1; i++) {
            arr[i] = arr[i-1]+i;
        }
        while(n > 0) {
            int index = 1;
            while(arr[index] <= n) {
                index++;
            }
            n -= arr[--index];
            out.append(map.get(index)).append(" ");
        }
        System.out.print(out);
    }
}