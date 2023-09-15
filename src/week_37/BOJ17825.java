package src.week_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 17825 - 주사위 윷놀이
 */
public class BOJ17825 {

    static int res;
    static int[] dices = new int[10], mal = new int[10];
    static int [] map = {
            0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, //0 ~ 21
            10, 13, 16, 19, 25, 30, 35, 40, 0,  //22 ~ 30
            20, 22, 24, 25, 30, 35, 40, 0,      //31 ~ 38
            30, 28, 27, 26, 25, 30, 35, 40, 0}; //39 ~ 47

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            dices[i] = Integer.parseInt(st.nextToken());
        }
        rec_func(0);
        System.out.println(res);
    }

    private static void rec_func(int depth) {
        if (depth == 10) {
            playGame();
            return;
        }
        for (int i = 0; i < 4; i++) {
            mal[depth] = i;
            rec_func(depth + 1);
        }
    }

    private static void playGame() {
        boolean[] visited = new boolean[map.length];
        int score = 0;
        int[] p = new int[4];

        for (int i = 0; i < 10; i++) {
            int nowDice = dices[i];
            int nowPiece = mal[i];
            if (isFinish(p[nowPiece]))
                return;

            int next = nextPoint(p[nowPiece], nowDice);
            if (isFinish(next)) {
                setVisited(visited, p[nowPiece], false);
                p[nowPiece] = next;
                continue;
            }
            if (visited[next])
                return;
            setVisited(visited, p[nowPiece], false);
            setVisited(visited, next, true);

            p[nowPiece] = next;
            score += map[p[nowPiece]];
        }
        res = Math.max(res, score);
    }

    private static void setVisited(boolean[] visited, int idx, boolean check) {
        if(idx == 20 || idx == 29 || idx == 37 || idx == 46) {
            visited[20] = check;
            visited[29] = check;
            visited[37] = check;
            visited[46] = check;
        } else if(idx == 26 || idx == 34 || idx == 43) {
            visited[26] = check;
            visited[34] = check;
            visited[43] = check;
        } else if(idx == 27 || idx == 35 || idx == 44) {
            visited[27] = check;
            visited[35] = check;
            visited[44] = check;
        }else if(idx == 28 || idx == 36 || idx == 45) {
            visited[28] = check;
            visited[36] = check;
            visited[45] = check;
        }else {
            visited[idx] = check;
        }
    }

    private static int nextPoint(int nowIdx, int dice) {
        int nextIdx = nowIdx + dice;
        if (nowIdx < 21) {
            if (nextIdx >= 21)
                nextIdx = 21;
        } else if (nowIdx < 30) {
            if (nextIdx >= 30)
                nextIdx = 30;
        } else if (nowIdx < 38) {
            if (nextIdx >= 38)
                nextIdx = 38;
        } else if (nowIdx < 47) {
            if (nextIdx >= 47)
                nextIdx = 47;
        }

        if (nextIdx == 5)
            return 22;
        else if (nextIdx == 10)
            return 31;
        else if (nextIdx == 15)
            return 39;

        return nextIdx;
    }

    private static boolean isFinish(int idx) {
        return idx == 21 || idx == 30 || idx == 38 || idx == 47;
    }
}
