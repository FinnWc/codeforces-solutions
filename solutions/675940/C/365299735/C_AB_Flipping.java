import java.io.*;
import java.util.*;

public class C_AB_Flipping {
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
            String s = fs.next();
            char[] sChar = s.toCharArray();
            int index = 0;
            boolean foundSwap = false;
            int counter = 0;
            int backTrackIndex = 0;
            boolean[] swapped = new boolean[sChar.length-1];
            if(sChar.length == 1) {
                out.append(counter + "\n");
                continue;
            }
            while(index < sChar.length-1) {
                if(!swapped[index] && sChar[index] == 'A' && sChar[index+1] == 'B') {
                    foundSwap = true;
                    backTrackIndex = index-1;
                    counter++;
                    swapped[index] = true;
                    sChar[index] = 'B';
                    sChar[index+1] = 'A';
                    
                }
                while(backTrackIndex>=0 && !swapped[backTrackIndex] && foundSwap && sChar[backTrackIndex] == 'A' && sChar[backTrackIndex+1] == 'B') {
                    counter++;
                    swapped[backTrackIndex] = true;
                    sChar[backTrackIndex] = 'B';
                    sChar[backTrackIndex+1] = 'A';
                    backTrackIndex--;
                }
                foundSwap = false;
                index++;
            }
            out.append(counter + "\n");
        }

        System.out.print(out);
    }
}