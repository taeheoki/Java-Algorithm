package src.week_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 3980 - 선발 명단
 */
public class Pro3980 {
    static int T, res;
    static int[][] players = new int[11][11];
    static boolean[] used = new boolean[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            for (int i = 0; i < 11; i++)
                Arrays.fill(players[i], 0);
            Arrays.fill(used, false);

            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    players[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            pro();
        }
    }

    private static void pro() {
        res = 0;
        dfs(0, 0);
        System.out.println(res);
    }

    private static void dfs(int index, int sum) {
        if (index == 11) {
            res = Math.max(res, sum);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (players[index][i] == 0)
                continue;
            if (used[i])
                continue;
            used[i] = true;
            dfs(index + 1, sum + players[index][i]);
            used[i] = false;
        }
    }
}
