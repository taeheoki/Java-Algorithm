package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2852 - NBA 농구
 */
public class Pro2852 {
    static int N, firstWin, secondWin;
    static int[] goal, MM, SS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        goal = new int[N + 1];
        MM = new int[N + 1];
        SS = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            goal[i] = Integer.parseInt(st.nextToken());
            StringTokenizer stTime = new StringTokenizer(st.nextToken(), ":");
            MM[i] = Integer.parseInt(stTime.nextToken());
            SS[i] = Integer.parseInt(stTime.nextToken());
        }
        pro();
    }

    private static void pro() {
        int firstMM = 0;
        int firstSS = 0;
        int secondMM = 0;
        int secondSS = 0;

        for (int i = 1; i <= N; i++) {
            if (goal[i] == 1) {
                firstWin++;
            } else {
                secondWin++;
            }
            if (i == N)
                break;
            if (firstWin > secondWin) {
                firstMM += MM[i + 1] - MM[i] - 1;
                firstSS += 60 + SS[i + 1] - SS[i];
            } else if (firstWin < secondWin) {
                secondMM += MM[i + 1] - MM[i] - 1;
                secondSS += 60 + SS[i + 1] - SS[i];
            }
        }
        if (firstWin > secondWin) {
            firstMM += 48 - MM[N] - 1;
            firstSS += 60 - SS[N];
        } else if (firstWin < secondWin) {
            secondMM += 48 - MM[N] - 1;
            secondSS += 60 - SS[N];
        }

        firstMM += firstSS / 60;
        firstSS %= 60;
        secondMM += secondSS / 60;
        secondSS %= 60;

        System.out.printf("%02d:%02d\n", firstMM, firstSS);
        System.out.printf("%02d:%02d", secondMM, secondSS);
    }
}
