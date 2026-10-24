import java.io.*;
import java.util.*;

public class LSubwayAnagram {
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

        String p = fs.next();
        String s = fs.next();
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        char[] pChar = p.toCharArray();
        char[] sChar = s.toCharArray();

        for(char c : pChar) {
            pMap.put(c, pMap.getOrDefault(c,0) + 1);
        }
        for(int i = 0; i < pChar.length; i++) {
            sMap.put(sChar[i],sMap.getOrDefault(sChar[i],0) + 1);
        }
        boolean[] goodIndex = new boolean[s.length()+1];
        int count = 0;
        if(pMap.equals(sMap)) {
            count++;
            goodIndex[1] = true;
        }
        for(int i = 1; i <= sChar.length-pChar.length; i++) {
            sMap.put(sChar[i-1], sMap.get(sChar[i-1]) - 1);
            if(sMap.get(sChar[i-1]) == 0) {
                sMap.remove(sChar[i-1]);
            }
            sMap.put(sChar[i+pChar.length-1], sMap.getOrDefault(sChar[i+pChar.length-1],0) + 1);
            if(pMap.equals(sMap)) {
                count++;
                goodIndex[i+1] = true;
            }
        }
        out.append(count).append("\n");
        for(int i = 1; i < goodIndex.length; i++) {
            if(goodIndex[i]) {
                out.append(i).append(" ");
            }
        }
        System.out.print(out);
    }
}