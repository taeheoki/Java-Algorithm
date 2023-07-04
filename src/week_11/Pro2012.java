package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 2012 - 등수 매기기
 * 문제 이해: N명의 학생들에게 자신이 몇등을 할지에 대한 예상 등수를 적어서 제출하도록 한다.
 *          각 사람이 제출한 예상 등수를 바탕으로 임의의 등수를 매기기로 하는데
 *
 */
public class Pro2012 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.abs(arr[i - 1] - i);
        }
        System.out.println(sum);
    }
}
