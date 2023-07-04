package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 14676 - 영우는 사기꾼?
 * 문제 이해: 우주전쟁이라는 게임은 각 플레이어가 건물을 건설하고, 건물에서 유닛을 생성하여 싸운다.
 *          이때, 건물을 짓는 순서가 정해져 있다.
 *          치트키를 사용하면 건물을 짓는 순서와 상관없이 건물을 지을 수 있게 되는데,
 *          영우와 영선이는 치트키를 사용하지 않고 게임을 하기로 하였으나, 이상하게 영우는 매번 게임을 이기게 되어
 *          이를 의심한 영선이는 영우의 선물 건설/파괴 정보를 확인해보았다.
 *          이를 통해 치트키의 사용 유무를 파악해보자.
 */
public class Pro14676 {
    static StringBuilder sb = new StringBuilder();
    static int N, M, K;
    static int[] indeg, buildings;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        boolean flag = false;
        indeg = new int[N + 1];
        buildings = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            indeg[to]++;
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd_type = Integer.parseInt(st.nextToken());
            int building = Integer.parseInt(st.nextToken());
            if (cmd_type == 1) {
                if (indeg[building] == 0) {
                    buildings[building]++;
                    if (buildings[building] <= 1) {
                        for (int y : adj[building]) {
                            indeg[y]--;
                        }
                    }
                }
                else {
                    sb.append("Lier!");
                    flag = true;
                    break;
                }
            } else if (cmd_type == 2) {
                if (buildings[building] > 0) {
                    buildings[building]--;
                    if (buildings[building] == 0) {
                        for (int y : adj[building]) {
                            indeg[y]++;
                        }
                    }
                } else {
                    sb.append("Lier!");
                    flag = true;
                    break;
                }
            }
        }
        if (!flag)
            sb.append("King-God-Emperor");
        System.out.println(sb);
    }
}
