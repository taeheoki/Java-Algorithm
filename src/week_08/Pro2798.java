package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2798 - 블랙잭
 * 문제 이해: 카드의 합이 21이 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만들어 보자
 *          주어진 숫자 배열에서 3장을 꺼내 M을 넘지 않으면서 가장 가까운 수를 출력하라.
 */
public class Pro2798 {
    static int N, M, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            rec_func(1, i, arr[i]);
        }
        System.out.println(res);
    }

    private static void rec_func(int depth, int start, int sum) {
        if (depth == 3) {
            if (sum <= M && M - res > M - sum)
                res = sum;
            return;
        }
        for (int i = start + 1; i < N; i++) {
            sum += arr[i];
            rec_func(depth + 1, i, sum);
            sum -= arr[i];
        }
    }
}
