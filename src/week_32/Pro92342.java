package src.week_32;

import java.util.Arrays;

/**
 * 프로그래머스 - 양궁대회
 */
public class Pro92342 {

    static int g_n, score;
    static int[] g_info, lionList, result = {-1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
        result = new int[]{-1};
        score = 0;
        System.out.println(Arrays.toString(solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
        result = new int[]{-1};
        score = 0;
        System.out.println(Arrays.toString(solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})));
        result = new int[]{-1};
        score = 0;
        System.out.println(Arrays.toString(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})));
    }

    public static int[] solution(int n, int[] info) {
        g_n = n;
        g_info = info;
        lionList = new int[11];
        rec_func(0, 0);
        return result;
    }

    private static void rec_func(int depth, int start) {
        if (depth == g_n) {
            int apeachSum = 0;
            int lionSum = 0;
            for (int i = 0; i < 11; i++) {
                if (g_info[i] >= lionList[i] && g_info[i] != 0)
                    apeachSum += 10 - i;
                else if (g_info[i] < lionList[i])
                    lionSum += 10 - i;
            }
            if (apeachSum < lionSum && score < lionSum - apeachSum) {
                score = lionSum - apeachSum;
                result = lionList.clone();
            } else if (apeachSum < lionSum && score == lionSum - apeachSum) {
                for (int i = 10; i >= 0; i--) {
                    if (result[i] < lionList[i]) {
                        result = lionList.clone();
                        break;
                    } else if (result[i] > lionList[i]) {
                        break;
                    }
                }
            }
            return;
        }
        for (int i = start; i < 11; i++) {
            if (i == 10) {
                lionList[i] += g_n - depth;
                rec_func(g_n, i + 1);
                lionList[i] -= g_n - depth;
                return;
            } else if (g_info[i] >= g_n - depth)
                continue;
            if (i != 10) {
                lionList[i] += g_info[i] + 1;
                rec_func(depth + g_info[i] + 1, i + 1);
                lionList[i] -= g_info[i] + 1;
            }
        }
    }
}
