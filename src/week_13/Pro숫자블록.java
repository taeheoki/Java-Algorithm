package src.week_13;

import java.util.Arrays;

/**
 * 프로그래머스 - 숫자 블록
 * 문제 이해: 블록을 설치하기 위해 약간의 규칙을 적용하여 블록을 설치한다.
 *          n * i 위치에 블록을 설치해볼 것이다.
 */
public class Pro숫자블록 {
    static int begin, end;

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(1, 10)));
//        System.out.println(Arrays.toString(solution(2, 10)));
        System.out.println(Arrays.toString(solution(100000014, 100000016)));
        System.out.println(100000014 / 6);
    }

    public static int[] solution(long begin, long end) {
        int[] arr = new int[(int) (end - begin + 1)];
        for (int i = (int) begin; i <= end; i++) {
            if (i == 1)
                arr[(int) (i - begin)] = 0;
            else
                arr[(int) (i - begin)] = 1;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0 && i / j <= 10000000) {
                    arr[(int) (i - begin)] = (int) (i / j);
                    break;
                }
                if (i % j == 0)
                    arr[(int) (i - begin)] = j;
            }
        }
        return arr;
    }
}
