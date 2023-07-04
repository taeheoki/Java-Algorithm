package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 9489 - 사촌
 * 문제 이해: 주어진 연속된 집합을 규칙을 통해 트리를 만들었을 때,
 *          노드 번호 k의 친척 수를 출력하라.
 *          - 첫 번째 정수는 트리의 루트 노드이다.
 *          - 이후 등장하는 연속된 수의 집합은 루트의 자식을 나타낸다.
 *            이 집합에 포함되는 수의 첫 번째 수는 항상 루트 노드 + 1보다 크다.
 *          - 그 다음부터는 모든 연속된 수의 집합은 아직 자식이 없는 노드의 자식이 된다.
 *            그러한 노드가 여러 가지 인 경우에는 가장 작은 수를 가지는 노드의 자식이 된다.
 *          - 집합은 수가 연속하지 않은 곳에서 구분된다.
 */
public class Pro9489 {
    static StringBuilder sb = new StringBuilder();
    static int n, k, kIdx;
    static int[][] tree;
    static Map<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0)
                break;
            tree = new int[n][2];
            st = new StringTokenizer(br.readLine());
            int pre = -1;
            int size = 0;
            int pIdx = -1;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != pre + 1 && i != 0) {
                    pIdx = i - size - 1;
                } else if (i != 0){
                    size++;
                }
                pre = num;
                tree[i][0] = i;
                tree[i][1] = pIdx;
                if (num == k)
                    kIdx = i;
            }
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        int cnt = 0;
        int kpIdx = tree[kIdx][1];
        for (int i = 1; i < n; i++) {
            int ipIdx = tree[i][1];
            if (tree[ipIdx][0] != tree[kpIdx][0] && tree[ipIdx][1] == tree[kpIdx][1])
                cnt++;
        }
        sb.append(cnt).append("\n");
    }
}