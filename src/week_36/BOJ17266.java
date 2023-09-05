package src.week_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 17266 - 어두운 굴다리
 */
public class BOJ17266 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int left = 0;
        int right = N;
        int res = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(res);
    }

    private static boolean isPossible(int mid) {
        boolean flag = false;
        int prevRight = 0;
        for (int position : arr) {
            int left = position - mid;
            int right = position + mid;
            if (prevRight < left) {
                break;
            }
            prevRight = right;
            if (right >= N) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
