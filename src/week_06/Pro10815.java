package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 10815번 숫자 카드
 * 시간 복잡도: O(M * logN)
 */
public class Pro10815 {
    static int N;
    static int[] A;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int src = Integer.parseInt(st.nextToken());
            int tmp = bSearch(src);
            if (src == A[tmp])
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    private static int bSearch(int X) {
        int left = 0;
        int right = N -1;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] <= X) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
