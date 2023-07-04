package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2470번 두 용액
 * 시간 복잡도: O(NlogN)
 */
public class Pro2470 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] elem = {arr[0], arr[1]};
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = arr.length - 1;
            int res = left;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] <= Math.abs(arr[i])) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (i == res)
                res = i + 1;
            if (res != arr.length) {
                if (Math.abs(arr[i] + arr[res]) < Math.abs(elem[0] + elem[1])) {
                    elem[0] = arr[i];
                    elem[1] = arr[res];
                }
                if (res != arr.length - 1 && Math.abs(arr[i] + arr[res + 1]) < Math.abs(elem[0] + elem[1])) {
                    elem[0] = arr[i];
                    elem[1] = arr[res + 1];
                }
            }
        }
        System.out.println(elem[0] + " " + elem[1]);
    }
}
