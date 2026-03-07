import java.io.*;
import java.util.*;

public class E_Asterisk_Minor_Template {
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
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            String a = fs.next();
            String b = fs.next();
            //was getting very stuck on this problem, used a few AI hints to realize the solution was much easier than I thought
            if(a.charAt(0) == b.charAt(0)) {
                out.append("YES\n").append(a.charAt(0) + "*").append("\n");
                continue;
            } else if(a.charAt(a.length()-1) == b.charAt(b.length()-1)) {
                out.append("YES\n").append("*" + a.charAt(a.length()-1)).append("\n");
                continue;
            } else {
                String matching = "";
                Boolean found = false;
                for(int i = 0; i < a.length()-1 && !found; i++) {
                    String substring = a.substring(i,i+2);
                    for(int j = 0; j < b.length()-1; j++) {
                        if(substring.equals(b.substring(j,j+2))) {
                            found = true;
                            matching = substring;
                            break;
                        }
                    }
                }
                if(found) {
                    out.append("YES\n").append("*" + matching + "*" + "\n");
                } else {
                    out.append("NO\n");
                }
            }
        }
        System.out.print(out);
    }
}