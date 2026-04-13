import java.io.*;
import java.util.*;

public class G_Easy_Assembly {
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
        int[][] blocks = new int[n][];
        int numBlocks = 0;
        ArrayList<Integer> vals = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int k = fs.nextInt();
            blocks[i] = new int[k];
            numBlocks += k;
            for(int j = 0; j < k; j++) {
                blocks[i][j] = fs.nextInt();
                vals.add(blocks[i][j]);
            }
        }
        int[] sortedVals = new int[numBlocks];
        for(int i = 0; i < numBlocks; i++) {
            sortedVals[i] = vals.get(i);
        }
        Arrays.sort(sortedVals);

        //got some AI help with coming up with the idea of numbering based on rank and     
        //with the adjacency calculations
        HashMap<Integer,Integer> rank = new HashMap<>();
        for(int i = 0; i < numBlocks; i++) {
            rank.put(sortedVals[i], i+1);
        }


        int good = 0;
        for(int[] tower : blocks) {
            for(int i = 0; i + 1 < tower.length; i++) {
                int top = rank.get(tower[i]);
                int bottom = rank.get(tower[i+1]);
                if(bottom == top + 1) {
                    good++;
                }
            }
        }
        int pieces = numBlocks - good;
        int splits = pieces - n;
        int combines = pieces - 1;
        out.append(splits + " " + combines);
        System.out.print(out);
    }
}