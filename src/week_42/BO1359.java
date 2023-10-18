package src.week_42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1359 - 복권
 */
public class BO1359 {
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        init();
        pro();
    }

    private static void pro() {
        double answer = 0;

        for (int i = K; i <= M; i++) {
            answer += combination(M, i) * combination(N - M, M - i);
        }

        double totalCase = combination(N, M);

        System.out.println(answer / totalCase);
    }

    // 조합 계산 함수
    public static double combination(int n, int r) {
        if (r == 0 || r == n)
            return 1;

        // 조합 계산식을 반복문으로 구현
        double result = 1;
        for (int i = 1; i <= r; i++) {
            result *= (n - i + 1) / (double)i;
        }

        return result;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
