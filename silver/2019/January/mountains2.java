import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class mountains2 {
    static int n;
    static int[][] ar;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File("mountains.in"));
//        PrintWriter pw = new PrintWriter("mountains.out");
////        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        ar = new int[n][2];



//        for (int i = 0; i < n; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            ar[i][0] = x - y;
//            ar[i][1] = x + y;
//        }

        n = 3;
        ar = new int[][] {
                {-2, 10}, {5, 9}, {-3, 7}
        };

        Arrays.sort(ar, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));

        for(int[] sub : ar)
            System.out.println(Arrays.toString(sub));

        LinkedList<Integer[]> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Integer[] {ar[i][0], ar[i][1]});
        }

        int count = 0;

        while(!list.isEmpty()) {
            Integer[] mt = list.remove(0);
            count++;

            Iterator it = list.iterator();

            while (it.hasNext()) {
                Integer[] subMt = (Integer[]) (it.next());
                if (subMt[0] >= mt[1]) break;
                if (subMt[1] <= mt[1]) {
                    System.out.println(subMt[0] + "," + subMt[1]);
                    it.remove();
                }
            }
        }

        System.out.println(count);

    }
}

