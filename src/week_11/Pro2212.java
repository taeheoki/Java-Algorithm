package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BOJ 2212 - 센서
 * 문제 이해: N개의 센서, K개의 집중국이 있을 때, 집중국의 경우 센서의 수신 가능 영역을 조절할 수 있다.
 *          N개의 센서가 적어도 하나의 집중국과는 통신이 가능해야 하며, 집중국의 유지비 문제로 인해 각 집중국의 수신 가능 영역의
 *          길이의 합을 최소화 해야 한다.
 *          - 입력으로 들어오는 N개의 센서는 각각 x_i 의 좌표를 가지고 있습니다.
 *          - 집중국은 각각 [s_i, e_i] 의 수신 가능영역을 가질 수 있습니다. (s_i = e_i 도 가능합니다)
 *          - 문제에서 요구하는 것은, K개의 집중국의 수신 가능영역 길이의 합을 최소화하는 것입니다.
 */
public class Pro2212 {
    static int N, K;
    static int[] arr, diff;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        Arrays.sort(arr);

        diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);
        int sum = 0;
        for (int i = 0 ; i < N - K; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}
