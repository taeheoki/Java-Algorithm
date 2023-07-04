package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * BOJ 15900 - 나무 탈출
 * 문제 이해: 성원이가 게임을 먼저 시작할 때 형석이를 이길 수 있는가,
 *          두 사람이 번갈아 가면서 게임말을 움직인다. 처음에는 트리의 모든 리프 노드에 게임말이 하나씩 놓여있는 채로 시작한다.
 *          하나씩 말을 움직여 마지막에 말을 고를 수 없을 때 그 사람이 지게 된다.
 *                         1
 *                     /  \    \
 *                   3     4    8
 *                   |    / \
 *                   2   6  7
 *                       |
 *                       5
 *                   2   3  2   1
 *                   주어진 리프노드에서의 합이 같아지면 성원이가 진다.
 *                   즉,
 * 시간 복잡도:
 */
public class Pro15900 {
    static int N;
    static ArrayList<Integer>[] adj;
    static String tmp;
    static ArrayList<Integer> leaf_node = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        while ((tmp = br.readLine()) != null && !tmp.isEmpty()) {
            StringTokenizer st = new StringTokenizer(tmp);
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1 - 1].add(v2 - 1);
            adj[v2 - 1].add(v1 - 1);
        }
        pro();
    }

    private static void pro() {
        dfs(0, -1, 0);

        // leaf_node 를 이용해 답을 구해내자.
        int sum = leaf_node.stream().mapToInt(s -> s).sum();
        if (sum % 2 == 0)
            System.out.println("No");
        else
            System.out.println("Yes");
    }

    private static void dfs(int x, int par, int depth) {
        if (adj[x].size() == 1 && x != 0)
            leaf_node.add(depth);
        for (int y : adj[x]) {
            if (y == par)
                continue;
            dfs(y, x, depth + 1);
        }
    }
}
