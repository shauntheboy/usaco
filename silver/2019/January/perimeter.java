import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class perimeter {
    static int n;
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("perimeter.in"));
        PrintWriter pw = new PrintWriter("perimeter.out");
        n = scanner.nextInt();
        Character[][] input = new Character[n][n];
        for (int i = 0; i < n; i++) {
            String string = scanner.next();
            for (int j = 0; j < n; j++) {
                input[i][j] = string.charAt(j);
                //System.out.print(input[i][j]);
            }
            System.out.println();
        }
        int biggest_size = 0;
        int biggest_per = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] fill = floodfill(input, i, j);
                if (fill[0] != 0 && fill[1] != 0) {
                    if (biggest_size < fill[0]) {
                        biggest_size = fill[0];
                        biggest_per = fill[1];
                    }
                    if (biggest_size == fill[0]) {
                        biggest_size = fill[0];
                        if (biggest_per > fill[1]) {
                            biggest_size = fill[0];
                            biggest_per = fill[1];
                        }
                    }
                }
            }
        }
        //System.out.println(biggest_size + " " + biggest_per);
        pw.println(biggest_size + " " + biggest_per);
        pw.close();


    }

    private static int[] floodfill(Character[][] ar, int x, int y) {
        if (ar[x][y] != '#') {
            return new int[]{0, 0};
        }

        int size = 0;
        int per = 0;

        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{x, y});
        ar[x][y] = '!';

        while (!stack.isEmpty()) {
            int[] pt = stack.pop();
            size += 1;
            ArrayList<int[]> adjs = getAdj(pt);
            per += 4 - adjs.size();
            for (int[] adj : adjs) {
                int rr = adj[0];
                int cc = adj[1];
                if (ar[adj[0]][adj[1]] == '#') {
                    ar[rr][cc] = '!';
                    stack.add(new int[]{rr, cc});
                }
                else if (ar[rr][cc] == '.') {
                    per++;
                }
            }


        }
        return new int[]{size, per};

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static ArrayList<int[]> getAdj(int[] pt) {
        ArrayList<int[]> ret = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int rr = pt[0] + dy[i];
            int cc = pt[1] + dx[i];

            if (rr >= 0 && rr < n && cc >= 0 && cc < n) {
                ret.add(new int[]{rr, cc});
            }
        }
        return ret;
    }
}
