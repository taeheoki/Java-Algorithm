package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 3584 - 가장 가까운 공통 조상
 * 문제 이해: 루트가 있는 트리가 주어지고, 두 노드가 주어졌을 때 그 두 노드의
 *          가장 가까운 공통 조상을 출력하라
 *          뭘 루트노드로 잡든 상관없는것 같다, 이후 각 노드별 깊이를 계산하고,
 *          비교 노드의 조상 노드의 깊이가 같은 것끼리 비교해 올라가면 될 것 같다.
 * 시간 복잡도: O(T * N)
 */
public class Pro3584 {
    static int T, N;
    static int[] depth, parent, find_node = new int[2];
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N];
            adj = new ArrayList[N];
            for (int j = 0; j < N; j++)
                adj[j] = new ArrayList<>();
            for (int j = 0; j < N - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int par = Integer.parseInt(st.nextToken()) - 1;
                int child = Integer.parseInt(st.nextToken()) - 1;
                adj[par].add(child);
                parent[child] = par;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            find_node[0] = Integer.parseInt(st.nextToken()) - 1;
            find_node[1] = Integer.parseInt(st.nextToken()) - 1;
            pro();
        }
    }

    private static void pro() {
        // 루트 찾기
        int root = 0;
        while (true) {
            if (parent[root] == 0)
                break;
            root = parent[root];
        }
        depth = new int[N];
        dfs(root, -1);

        // 주어진 노드를 이용해 공통 조상 찾기
        int find;
        while (true) {
            if (depth[find_node[0]] > depth[find_node[1]]) {
                find_node[0] = parent[find_node[0]];
            } else if (depth[find_node[0]] < depth[find_node[1]]) {
                find_node[1] = parent[find_node[1]];
            } else {
                if (find_node[0] != find_node[1]) {
                    find_node[0] = parent[find_node[0]];
                    find_node[1] = parent[find_node[1]];
                } else {
                    find = find_node[0] + 1;
                    break;
                }
            }
        }
        System.out.println(find);
    }

    private static void dfs(int x, int par) {
        for (int y : adj[x]) {
            if (y == par)
                continue;
            depth[y] = depth[x] + 1;
            parent[y] = x;
            dfs(y, x);
        }
    }
}
