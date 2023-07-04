package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 백준 7795번 먹을 것인가 먹힐 것인가
 */
public class Pro7795 {
    static StringBuilder sb = new StringBuilder();
    static int N, M, total;
    static int[] A, B;

    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R] 에서 X 미만의 수(X 보다 작은 수) 중 제일 오른쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 L - 1 을 return 한다
        int result = L - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] < X) {
                result = mid;
                L = mid + 1;
            } else if (A[mid] >= X) {
                R = mid - 1;
            }
        }
        return result;
    }

    static void pro() {
        // B 배열에 대해 이분탐색을 할 예정이니까, 정렬을 해주자!
        Arrays.sort(B, 1, M + 1);

        int res = 0;
        for (int i = 0; i < N; i++) {
            // A[i] 를 선택했을 때, B 에서는 A[i]보다 작은 게 몇 개나 있는 지 count하기
            res += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = new int[N];
            M = Integer.parseInt(st.nextToken());
            B = new int[M + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                A[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++)
                B[j] = Integer.parseInt(st.nextToken());
            pro();
        }
    }
}
