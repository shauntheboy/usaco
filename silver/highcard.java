/*
Bessie the cow is a huge fan of card games, which is quite surprising, given her lack of opposable thumbs.
Unfortunately, none of the other cows in the herd are good opponents. They are so bad, in fact, that they always play
in a completely predictable fashion! Nonetheless, it can still be a challenge for Bessie to figure out how to win.
Bessie and her friend Elsie are currently playing a simple card game where they take a deck of 2N cards, conveniently
numbered 1…2N, and divide them into N cards for Bessie and N cards for Elsie. The two then play N rounds, where in each
round Bessie and Elsie both play a single card, and the player with the highest card earns a point.

Given that Bessie can predict the order in which Elsie will play her cards, please determine the maximum number of
points Bessie can win.

INPUT FORMAT (file highcard.in):
The first line of input contains the value of N (1≤N≤50,000).
The next N lines contain the cards that Elsie will play in each of the successive rounds of the game. Note that it
is easy to determine Bessie's cards from this information.

OUTPUT FORMAT (file highcard.out):
Output a single line giving the maximum number of points Bessie can score.
SAMPLE INPUT:
3
1
6
4
SAMPLE OUTPUT:
2
Here, Bessie must have cards 2, 3, and 5 in her hand, and she can use these to win at most 2 points by saving the 5
until the end to beat Elsie's 4.

Problem credits: Austin Bannister and Brian Dean
 */
import java.util.Arrays;
import java.util.Scanner;

public class highcard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] elsie = new int[n];
        boolean[] use = new boolean[n * 2];
        for (int i = 0; i < n; i++) {
            elsie[i] = scanner.nextInt() - 1;
            use[elsie[i]] = true;
        }
        Arrays.sort(elsie);
        int[] bessie = new int[n];
        int count = 0;
        for (int i = 0; i < n * 2; i++) {
            if (use[i] == false) {
                bessie[count++] = i;
            }
        }
        int result = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            while (count2 < n && bessie[count2] < elsie[i]) {
                count2++;
            }

            if (count2 == n) {
                break;
            }
            else {
                result++;
                count2++;
            }
        }
        System.out.println(result);


    }
}
