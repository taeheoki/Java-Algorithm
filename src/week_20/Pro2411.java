package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * BOJ 2411 - 아이템 먹기
 */
public class Pro2411 {
    static int N, M, A, B;
    static int[][] map, dp;
    static ArrayList<Item> items = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        int y = 0, x = 0;
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            items.add(new Item(y, x));
        }
        if (y != N && x != M)
            items.add(new Item(N, M));
        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            map[y][x] = 2; // 장애물
        }
        Collections.sort(items);
        pro();
    }

    private static void pro() {
        dp = new int[N +1][M + 1];
        dp[1][1] = 1;
        int res = 1;

        int cur_y = 1;
        int cur_x = 1;
        for (Item item : items) {
            int item_y = item.y;
            int item_x = item.x;
            res *= setCase(cur_y, cur_x, item_y, item_x);
            cur_y = item_y;
            cur_x = item_x;
        }
        System.out.println(res);
    }

    private static int setCase(int curY, int curX, int itemY, int itemX) {
        for (int i = curY; i <= itemY; i++) {
            if (map[i][curX] == 2)
                break;
            dp[i][curX] = 1;
        }
        for (int i = curX; i <= itemX; i++) {
            if (map[curY][i] == 2)
                break;
            dp[curY][i] = 1;
        }

        for (int i = curY + 1; i <= itemY; i++) {
            for (int j = curX + 1; j <= itemX; j++) {
                if (map[i][j] != 2)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[itemY][itemX];
    }

    private static class Item implements Comparable<Item> {
        int y;
        int x;

        public Item(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Item o) {
            if (this.y == o.y)
                return this.x - o.x;
            return this.y - o.y;
        }
    }

}
