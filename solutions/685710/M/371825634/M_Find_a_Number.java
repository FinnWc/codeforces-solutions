import java.io.*;
import java.util.*;

public class M_Find_a_Number {
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

        //this problem was pretty daunting to me. I rarely solve problems this hard on the psets but I thought it would be good for me to
        //give it a try myself then work through it with AI slowly if I didn't understand. Over the course of an hour or so I went through this 
        //code line by line and now I can say that I fully understand everything and think I could write this solution with no AI and use BFS in general through a 
        //graph that I construct myself by myself for future problems. Learned a lot and this problem really isn't that hard/scary to me anymore. 
        int d = fs.nextInt();
        int s = fs.nextInt();
        boolean[][] visited = new boolean[d][s+1];
        int[][] prevR = new int[d][s+1];
        int[][] prevS = new int[d][s+1];
        int[][] prevDigit = new int[d][s+1];
        for(int i = 0; i < d; i++) {
            Arrays.fill(prevR[i], -1);
            Arrays.fill(prevS[i], -1);
            Arrays.fill(prevDigit[i], -1);
        }
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 1; i < 10; i++) {
            if(i > s) {
                break;
            }
            int sum = i;
            int rem = i % d;
            if(!visited[rem][sum]) {
                visited[rem][sum] = true;
                prevDigit[rem][sum] = i;
                q.offer(new int[]{rem,sum});
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int sum = cur[1];
            if(r == 0 && sum == s) {
                break;
            }
            for(int i = 0; i < 10; i++) {
                int newSum = sum+i;
                if(newSum > s) {
                    break;
                }
                int newRem = (r * 10 + i) % d;
                if(!visited[newRem][newSum]) {
                    visited[newRem][newSum] = true;
                    prevDigit[newRem][newSum] = i;
                    prevS[newRem][newSum] = sum;
                    prevR[newRem][newSum] = r;
                    q.offer(new int[]{newRem,newSum});
                }
            }
        }
        if(!visited[0][s]) {
            out.append(-1);
            System.out.print(out);
            return;
        }

        int r = 0;
        int sum = s;
        while(r != -1 && sum != -1) {
            out.append(prevDigit[r][sum]);
            int pr = prevR[r][sum];
            int ps = prevS[r][sum];
            r = pr;
            sum = ps;
        }
        System.out.print(out.reverse());
    }
}