package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * BOJ 1021 - 회전하는 큐
 */
public class Pro1021 {
    static int N, M, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
        System.out.println(ans);
    }

    private static void pro() {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        for (int i = 0; i < M; i++) {
            int cnt = 0;
            while (deque.peek() != arr[i]) {
                Integer num = deque.pollFirst();
                deque.add(num);
                cnt++;
            }
            ans += Math.min(cnt, deque.size() - cnt);
            deque.remove();
        }
    }
}
