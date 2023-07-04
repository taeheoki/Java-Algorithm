package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2428 - 표절
 * 문제 이해: 정렬 후 각각의 파일에 대한 이분탐색을 통해 90퍼가 되는 파일의 index를 찾고
 *          거기를 시작으로 파일을 비교한다고 가정한다.
 */
public class Pro2428 {
    static int N;
    static double[] files;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        files = new double[N];
        for (int i = 0; i < N; i++) {
            files[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(files);

        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += pro(i) - i;
        }
        System.out.println(sum);
    }

    private static int pro(int idx) {
        int left = idx + 1;
        int right = files.length - 1;
        int res = idx;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (files[idx] >= files[mid] * 0.9) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
