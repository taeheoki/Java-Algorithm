package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2531 - 회전 초밥
 * 문제 이해: 초밥집에서 쿠폰이벤트를 하게 되는데, 이를 잘 생각하여
 *          초밥을 가장 다양하게 먹는 경우 몇 가지 초밥을 먹는지 구해보라.
 * 시간 복잡도: O(N)
 */
public class Pro2531 {
    static int N, d, k, c, res;
    static int[] arr, visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 접시의 수
        d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        pro();
    }

    private static void pro() {
        visit = new int[d + 1];
        int cnt = 0;
        int right = -1;
        int length = 0;
        for (int left = 0; left < N; left++) {
            if (left != 0) {
                visit[arr[left - 1]]--;
                length--;
                if (visit[arr[left - 1]] == 0)
                    cnt--;
            }
            while (length < k && right + 1 < N + k) {
                right++;
                length++;
                visit[arr[right % N]]++;
                if (visit[arr[right % N]] == 1)
                    cnt++;
            }
            if (length == k) {
                if (visit[c] == 0)
                    res = Math.max(res, cnt + 1);
                else
                    res = Math.max(res, cnt);
            }
        }
        System.out.println(res);
    }
}
