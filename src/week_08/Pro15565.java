package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 15565 - 귀여운 라이언
 * 문제 이해: 라이언 인형(1)과 어피치 인형(2)이 놓여 있을 때,
 *          라이언 인형이 K개 이상 있는 가장 작은 연속된 인형들의 집합의 크기
 * 시간 복잡도: O(N)
 */
public class Pro15565 {
    static int N, K, ans = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int right = 0;
        int cnt_K = 0;
        int length = 1;
        for (int left = 1; left <= N; left++) {
            if (arr[left - 1] == 1)
                cnt_K--;
            length--;
            while (cnt_K < K && right + 1 <= N) {
                right++;
                if (arr[right] == 1)
                    cnt_K++;
                length++;
            }
            if (cnt_K >= K)
                ans = Math.min(ans, length);
        }
        if (ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);
    }

}
