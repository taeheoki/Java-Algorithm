package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 11728 - 배열 합치기
 * 문제 이해: 두 배열이 주어졌을 때, 두 배열을 합친 다음 정렬해서 출력하기
 * 시간 복잡도: O((N + M)log(N + M))
 */
public class Pro11728 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = N ; i < N + M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(s -> sb.append(s).append(" "));
        System.out.println(sb);
    }
}
