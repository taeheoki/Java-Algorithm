package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 11866 - 요세푸스 문제 0
 */
public class Pro11866 {
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            que.offer(i + 1);
        }
        pro();
    }

    private static void pro() {
        sb.append("<");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                que.offer(que.poll());
            }
            sb.append(que.poll());
            if (i != N - 1)
                sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
