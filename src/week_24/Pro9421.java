package src.week_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 9421 - 소수상근수
 */
public class Pro9421 {
    static int n;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[1000000 + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        // 소수 구하기
        for (int i = 2; i < n; i++) {
            if (!arr[i])
                continue;
            for (int j = i * 2; j < n; j += i) {
                arr[j] = false;
            }
        }
        // 상근 수 구하기
        for (int i = 2; i < n; i++) {
            if (!arr[i])
                continue;
            if (isPossible(i))
                System.out.println(i);
        }
    }

    private static boolean isPossible(int num) {
        int res = getSangeunsu(num);
        while (res > 2) {
            res = getSangeunsu(res);
            if (res == 4)
                break;
        }
        if (res == 1)
            return true;
        return false;
    }

    private static int getSangeunsu(int num) {
        int res = 0;
        while (num != 0) {
            res += Math.pow(num % 10, 2);
            num /= 10;
        }
        return res;
    }
}