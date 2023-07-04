package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2644 - 촌수계산
 * 문제 이해: 시작점인 사람과 끝점인 사람이 주어졌을 때 이 두사람의 관계를 따져 촌수를 출력하라.
 *          빙빙 돌아 답이 계산될 수 있기 때문에 그럴 경우 큰 수가 나오게 된다.
 *          이 문제의 경우 평균적으로 빠른 답을 구하기 위해 bfs가 적절하다 생각된다.
 * 시간 복잡도: O(MN)
 */
public class Pro2644 {
    static int n, m, ans;
    static int[] cmpPerson = new int[2];
    static ArrayList<Integer>[] persons;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++)
            cmpPerson[i] = Integer.parseInt(st.nextToken()) - 1;
        m = Integer.parseInt(br.readLine());
        persons = new ArrayList[n];
        for (int i  = 0; i < n; i++) {
            persons[i] = new ArrayList<>();
        }
        visit = new boolean[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 양방향 간선
            persons[x - 1].add(y - 1);
            persons[y - 1].add(x - 1);
        }
        bfs(cmpPerson[0]);
        System.out.println(ans);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int tmp = queue.poll();

                if (tmp == cmpPerson[1])
                    return;
                for (int person : persons[tmp]) {
                    if (visit[person])
                        continue;
                    queue.offer(person);
                    visit[person] = true;
                }
            }
            ans++;
        }
        ans = -1;
    }
}
