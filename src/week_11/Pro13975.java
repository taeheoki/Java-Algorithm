package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 13975 - 파일 합치기 3
 * 문제 이해: 전에 썻던 내용을 계속 합쳐가며 임시파일을 생성해 놓을건데, 최종적인 한 개의 파일을 오나성하는데 필요한 비용의 총합이 최소비용이
 *          되도록 하는 값을 출력하라.
 *          낮은 값을 먼저 앞에서 합쳐지게 해놓으면 전체적으로 최소비용이 만들어질 것이다.
 */
public class Pro13975 {
    static StringBuilder sb = new StringBuilder();
    static int T, K;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            K = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++)
                pq.offer(Long.parseLong(st.nextToken()));
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        long sum = 0;
        while (pq.size() > 1) {
            long x = pq.poll();
            long y = pq.poll();
            pq.offer(x + y);
            sum += x + y;
        }
        sb.append(sum).append('\n');
    }
}
