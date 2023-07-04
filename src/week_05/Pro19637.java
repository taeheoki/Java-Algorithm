package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 19637번 IF문 좀 대신 써줘
 * 시간 복잡도: M * logN
 */
public class Pro19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 칭호의 개수
        String[] state = new String[N];
        int[] num = new int[N];
        int M = Integer.parseInt(st.nextToken()); // 캐릭터들의 개수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            state[i] = st.nextToken();
            num[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            int index = inner_boundary(num,0, N - 1, power);
            sb.append(state[index]).append("\n");
        }
        System.out.println(sb);
    }

    private static int inner_boundary(int[] A, int left, int right, int power) {
        int index = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] >= power) {
                index = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return index;
    }
}
