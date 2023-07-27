package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 20546 - 🐜 기적의 매매법 🐜
 */
public class Pro20546 {
    static int k;
    static int[] arr = new int[14];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int junCost = initJunStock();
        int seungCost = initSeungStock();
        if (junCost > seungCost)
            System.out.println("BNP");
        else if (junCost < seungCost)
            System.out.println("TIMING");
        else
            System.out.println("SAMESAME");
    }

    private static int initSeungStock() {
        int cost = k;
        int cnt = 0;
        int highCnt = 0;
        int lowCnt = 0;
        for (int i = 2; i < 13; i++) {
            if (arr[i] > arr[i - 1]) {
                highCnt++;
                lowCnt = 0;
                if (highCnt >= 3) {
                    cost += cnt * arr[i];
                    cnt = 0;
                }
            } else if (arr[i] < arr[i - 1]) {
                highCnt = 0;
                lowCnt++;
                if (lowCnt >= 3) {
                    int tmp = cost / arr[i];
                    cnt += tmp;
                    cost -= tmp * arr[i];
                }
            }
        }
        return cnt * arr[13] + cost;
    }

    private static int initJunStock() {
        int cost = k;
        int cnt = 0;
        for (int i = 0; i < 13; i++) {
            int tmp = cost / arr[i];
            cnt += tmp;
            cost -= tmp * arr[i];
        }
        return cnt * arr[13] + cost;
    }
}
