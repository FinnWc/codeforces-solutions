import java.io.*;
import java.util.*;

public class D_Ahahahahahahahaha {
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
            int[] a = new int[n];
            //had the logic essentially correct, but was struggling to find out how to get the total number of elements 
            //in the output. Realized I could swap to an ArrayList approach thanks to an AI hint. 
            ArrayList<Integer> keptNums = new ArrayList<>();
            for(int i = 0; i < n; i++) { a[i] = fs.nextInt(); }
            for(int i = 0; i < n; i += 2) {
                int firstNum = a[i];
                int secondNum = a[i+1];
                if(firstNum == secondNum) {
                    keptNums.add(firstNum);
                    keptNums.add(secondNum);
                } else {
                    keptNums.add(0);
                }
            }
            out.append(keptNums.size() + "\n");
            for(int num : keptNums) {
                out.append(num + " ");
            }
            out.append("\n");
        }
        System.out.print(out);
    }
}