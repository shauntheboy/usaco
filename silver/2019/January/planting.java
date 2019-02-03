import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class planting {
    static int n;
    static int[] ar;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("planting.in"));
        PrintWriter pw = new PrintWriter("planting.out");
        n = scanner.nextInt();
        ar = new int[100000];

        for (int i = 0; i < n-1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ar[a-1]++;
            ar[b-1]++;
        }
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (ar[i] > d) {
                d = ar[i];
            }
        }
        pw.println(d + 1);
        pw.close();

    }
}
