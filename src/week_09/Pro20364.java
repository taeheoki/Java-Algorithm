package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 20364 - 부동산 다툼
 * 문제 이해: 이진 트리 모양의 땅으로 이루어진 마을이 있다.
 *          루트 번호: 1, 왼쪽 자식 땅 번호: 2 * K, 오른쪽 자식 땅 번호: 2 * K + 1
 *          오리마다 원하는 땅들이 존재한다. 원하는 땅을 점유할 수 있는지 없는지 출력하고
 *          만약 이미 점유된 땅을 지날수는 없고, 이때 가장 먼저 마주치는 점유된 땅의 번호를 출력하라.
 */
public class Pro20364 {
    static StringBuilder sb = new StringBuilder();
    static int N, Q, res;
    static boolean[] possession;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        possession = new boolean[N + 1];
        for (int i = 0; i < Q; i++) {
            int ori = Integer.parseInt(br.readLine());
            res = 0;
            pro(ori);
            if (res == 0)
                possession[ori] = true;
        }
        System.out.println(sb);
    }

    private static void pro(int target) {
        dfs(target);
        sb.append(res).append("\n");
    }

    private static void dfs(int land) {
        if (possession[land]) {
            res = land;
        }
        if (land >= 2)
            dfs(land / 2);
    }
}
