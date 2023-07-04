package src.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 1931번 회의실 배정
 */
public class Pro1931 {
    static int[][] arr;
    static int N;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int cnt = 0;
        int prev_end = 0;
        for (int i = 0; i < N; i++) {
            if (prev_end <= arr[i][0]) {
                prev_end = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
