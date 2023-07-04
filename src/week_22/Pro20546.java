package src.week_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 20546 - 🐜 기적의 매매법 🐜
 */
public class Pro20546 {
    static int N, cntA, cntB, moneyA, moneyB;
    static int[] arr = new int[14];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        moneyA = N;
        moneyB = N;
        int lowCnt = 0;
        int highCnt = 0;
        for (int i = 0; i < 13; i++) {
            // 준현
            if (moneyA / arr[i] > 0) {
                cntA += moneyA / arr[i];
                moneyA -= (moneyA / arr[i]) * arr[i];
            }

            // 성민
            if (i != 0) {
                if (arr[i] - arr[i -1] > 0) {
                    highCnt++;
                    lowCnt = 0;
                    if (highCnt >= 3) {
                        moneyB += arr[i] * cntB;
                        cntB = 0;
                    }
                } else if (arr[i] - arr[i -1] < 0) {
                    lowCnt++;
                    highCnt = 0;
                    if (lowCnt >= 3) {
                        cntB += moneyB / arr[i];
                        moneyB -= (moneyB / arr[i]) * arr[i];
                    }
                } else {
                    lowCnt = 0;
                    highCnt = 0;
                }
            }
        }
        moneyA += cntA * arr[13];
        moneyB += cntB * arr[13];
        if (moneyA > moneyB) {
            System.out.println("BNP");
        } else if (moneyA < moneyB) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
