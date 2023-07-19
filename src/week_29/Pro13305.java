package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 주유소 - 13305
 */
public class Pro13305 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int pivot = Integer.MAX_VALUE;
        long res = 0;
        int range = 0;
        for (int i = 0; i < N - 1; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp >= pivot) {
                range += arr[i];
            } else {
                res += (long) pivot * range;
                pivot = tmp;
                range = arr[i];
            }
        }
        res += (long) pivot * range;
        System.out.println(res);
    }
}
