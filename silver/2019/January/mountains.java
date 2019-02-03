import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class mountains {
    static int n;
    static int[][] ar;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("mountains.in"));
        PrintWriter pw = new PrintWriter("mountains.out");
//        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ar = new int[n][2];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            ar[i][0] = x - y;
            ar[i][1] = x + y;
        }

        Arrays.sort(ar, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));

        for(int[] sub : ar)
            System.out.println(Arrays.toString(sub));

//        LinkedList<Integer[]> list = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(new Integer[] {ar[i][0], ar[i][1]});
//        }

        boolean[] hidden = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (hidden[i]) {
                continue;
            }

            int[] mt1 = ar[i];

            for (int j = i + 1; j < n; j++) {
                int[] mt2 = ar[j];
                if (mt1[1] >= mt2[1]) {
                    hidden[j] = true;
                }
                if (mt1[1] <= mt2[0]) {
                    break;
                }
            }
        }

        int count = n;

        for (int i = 0; i < n; i++) {
//            System.out.println(hidden[i]);
            if (hidden[i]) {
                count--;
            }
        }
        pw.println(count);
        pw.close();
//        System.out.println(count);

    }
}

