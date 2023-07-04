package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 20208 - 진우의 민트초코우유
 */
public class Pro20208 {
    static int N, M, H, sr, sc, res;
    static ArrayList<Milk> milks = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    sr = i;
                    sc = j;
                } else if (tmp == 2) {
                    milks.add(new Milk(i, j));
                }
            }
        }
        visit = new boolean[milks.size()];
        dfs(M, sr, sc, 0);
        System.out.println(res);
    }

    private static void dfs(int hp, int r, int c, int cnt) {
        for (int i = 0; i < milks.size(); i++) {
            if (visit[i])
                continue;
            int dist = getDist(r, c, i);
            int homeDist = getDist(sr, sc, i);
            int tmp = hp;
            if (tmp >= dist) {
                tmp -= dist;
                tmp += H;
                visit[i] = true;
                if (tmp >= homeDist) {
                    res = Math.max(res, cnt + 1);
                }
                dfs(tmp, milks.get(i).r, milks.get(i).c, cnt + 1);
                visit[i] = false;
            }
        }
    }

    private static int getDist(int r, int c, int i) {
        int a = Math.abs(r - milks.get(i).r);
        int b = Math.abs(c - milks.get(i).c);
        return a + b;
    }

    private static class Milk {
        int r;
        int c;

        public Milk(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
