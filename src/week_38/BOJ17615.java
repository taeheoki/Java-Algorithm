package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 17615 - 볼 모으기
 */
public class BOJ17615 {
    static int N, red, blue, res = Integer.MAX_VALUE;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N];
        String data = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = data.charAt(i);
            if (arr[i] == 'R')
                red++;
            else
                blue++;
        }
        pro();
        System.out.println(res);
    }

    private static void pro() {
        int cmpRed = 0;
        int cmpBlue = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R')
                cmpRed++;
            else {
                cmpBlue++;
                if (cmpBlue == blue) {
                    res = Math.min(res, cmpRed);
                    break;
                }
            }
        }

        cmpRed = 0;
        cmpBlue = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'B')
                cmpBlue++;
            else {
                cmpRed++;
                if (cmpRed == red) {
                    res = Math.min(res, cmpBlue);
                    break;
                }
            }
        }

        cmpRed = 0;
        cmpBlue = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'R')
                cmpRed++;
            else {
                cmpBlue++;
                if (cmpBlue == blue) {
                    res = Math.min(res, cmpRed);
                    break;
                }
            }
        }

        cmpRed = 0;
        cmpBlue = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'B')
                cmpBlue++;
            else {
                cmpRed++;
                if (cmpRed == red) {
                    res = Math.min(res, cmpBlue);
                    break;
                }
            }
        }
    }
}
