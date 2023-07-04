package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 16953 - A -> B
 * 문제 이해: 정수 A를 B로 바꾸기 위해 2를 곱하거나 10을 곱하고 1을 더하는 식으로
 *          정수 B에 가까워 질 수 있다.
 *          이 때 A를 B로 바꾸는데 필요한 연산의 최솟값을 구하라.
 * 시간 복잡도: 10억이면 int로 가능
 */
public class Pro16953 {
    static long A, B;
    static int cnt;
//    static ArrayList<Long> visit = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        pro();
    }

    private static void pro() {
        int res = bfs(A);
        System.out.println(res + 1);
    }

    private static int bfs(long start) {
        Queue<Long> q = new LinkedList<>();
        q.offer(start);
//        visit.add(start);

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                long cur = q.poll();
                if (cur == B)
                    return cnt;

                long next = cur * 2;
//                if (!visit.contains(next) && next <= B) {
                if (next <= B) {
                    q.offer(next);
//                    visit.add(next);
                }
                next = cur * 10 + 1;
//                if (!visit.contains(next) && next <= B) {
                if (next <= B) {
                    q.offer(next);
//                    visit.add(next);
                }
            }
            cnt++;
        }
        return -2;
    }
}
