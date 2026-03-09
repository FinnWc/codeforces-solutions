import java.io.*;
import java.util.*;

public class J_Vasya_And_Password {
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
            String s = fs.next();
            //I was going to use arrys to solve this problem since I'm comfortable with them
            //asked AI what something else I could use would be to solve it to get practice and it said arraylists
            ArrayList<Integer> lowerCase = new ArrayList<>();
            ArrayList<Integer> upperCase = new ArrayList<>();
            ArrayList<Integer> digit = new ArrayList<>();
            char[] sChar = s.toCharArray();
            for(int i = 0; i < s.length(); i++) {
                //was also going to just use ascii values and compare with if statements
                //but thought there was a better way so google showed me the Character.isDigit() and other methods. Very handy
                char c = s.charAt(i);
                if(Character.isDigit(c)) {
                    digit.add(i);
                } else if(Character.isLowerCase(c)) {
                    lowerCase.add(i);
                } else if(Character.isUpperCase(c)) {
                    upperCase.add(i);
                }
            }
            //3
            if(!lowerCase.isEmpty() && !digit.isEmpty() && !upperCase.isEmpty()) {
                
            //2
            } else if(lowerCase.isEmpty() && !digit.isEmpty() && !upperCase.isEmpty()) {
                if (digit.size() > 1) {
                    sChar[digit.get(0)] = 'a';  
                } else {
                    sChar[upperCase.get(0)] = 'a';
                }
            } else if(!lowerCase.isEmpty() && digit.isEmpty() && !upperCase.isEmpty()) {
                if (lowerCase.size() > 1) {
                    sChar[lowerCase.get(0)] = '1';  
                } else {
                    sChar[upperCase.get(0)] = '1';
                }
            } else if(!lowerCase.isEmpty() && !digit.isEmpty() && upperCase.isEmpty()) {
                if (lowerCase.size() > 1) {
                    sChar[lowerCase.get(0)] = 'A';  
                } else {
                    sChar[digit.get(0)] = 'A';
                }
            //1
            } else if(lowerCase.isEmpty() && digit.isEmpty() && !upperCase.isEmpty()) {
                sChar[upperCase.get(0)] = 'a';
                sChar[upperCase.get(1)] = '1';
            } else if(lowerCase.isEmpty() && !digit.isEmpty() && upperCase.isEmpty()) {
                sChar[digit.get(0)] = 'a';
                sChar[digit.get(1)] = 'A';
            } else if(!lowerCase.isEmpty() && digit.isEmpty() && upperCase.isEmpty()) {
                sChar[lowerCase.get(0)] = '1';
                sChar[lowerCase.get(1)] = 'A';
            }
            out.append(new String(sChar) + "\n");
        }

        System.out.print(out);
    }
}