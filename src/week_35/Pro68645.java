package src.week_35;

import java.util.Arrays;

/**
 * 프로그래머스 - 삼각 달팽이
 * 1
 * 2 9
 * 3 10 8
 * 4 5 6 7
 */
public class Pro68645 {
    static int num = 1;
    static int[][] arr;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        num = 1;
        System.out.println(Arrays.toString(solution(5)));
        num = 1;
        System.out.println(Arrays.toString(solution(6)));
        num = 1;
        System.out.println(Arrays.toString(solution(7)));
        num = 1;
        System.out.println(Arrays.toString(solution(8)));
        num = 1;
        System.out.println(Arrays.toString(solution(9)));
    }

    public static int[] solution(int n) {

        arr = new int[n][];
        int size = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
            size += i + 1;
        }

        fill(0, n, 0);

        int[] answer = new int[size];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[index] = arr[i][j];
                index++;
            }
        }
        return answer;
    }

    private static void fill(int s, int n, int cnt) {
        for (int i = s * 2; i < n - cnt; i++) {
            arr[i][s] = num++;
        }
        for (int i = s + 1; i < n - cnt * 2; i++) {
            arr[n - cnt - 1][i] = num++;
        }
        for (int i = n - cnt - 2; i >= s * 2 + 1; i--) {
            arr[i][i - cnt] = num++;
        }
        if (n - 3 * cnt > 3)
            fill(s + 1, n, cnt + 1);
    }
}
