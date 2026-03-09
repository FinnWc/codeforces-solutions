import java.io.*;
import java.util.*;

public class I_Letters_Cyclic_Shift {
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

        String s = fs.next();
        StringBuilder sb = new StringBuilder();
        int onlyA = 0;
        boolean started = false;
        boolean ended = false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a' && !started) {
                onlyA++;
                sb.append(s.charAt(i));
                continue;
            } else if(s.charAt(i) != 'a' && !started){
                //found this logic online (google AI) for character switching
                char sChar = s.charAt(i);
                int pos = sChar - 'a';
                int newPosition = (pos - 1 + 26) % 26;
                sb.append((char)(newPosition + 'a'));
                started = true;
            } else if(s.charAt(i) == 'a' && started) {
                sb.append(s.substring(i));
                break;
            } else if(s.charAt(i) != 'a' && started) {
                char sChar = s.charAt(i);
                int pos = sChar - 'a';
                int newPosition = (pos - 1 + 26) % 26;
                sb.append((char)(newPosition + 'a'));
            }
        }
        if(onlyA == s.length()) {
            for(int i = 1; i < s.length(); i++) {
                out.append(s.charAt(i));
            }
            out.append("z");
        } else {
            out.append(sb.toString());
        }

        System.out.print(out);
    }
}