package src.week_13;

/**
 * 프로그래머스 - 다음 큰 숫자
 * 문제 이해: 자연수 n이 주어졌을 때 다음과 같은 규칙에 적용되는 다음 숫자를 출력하라.
 *          1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 *          2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 *          3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 */
public class Pro다음큰숫자 {
    public static void main(String[] args) {
        System.out.println(solution(78)); // 1001110 -> 1010011
        System.out.println(solution(15)); // 1111 -> 10111
    }

    public static int solution(int n) {
        // 이진법 변환 -> 비교(1의 갯수) 2진법 변환이 필요 없구나..
        int res = n;
        int cnt_one = countOne(res);
        while (true) {
            res++;
            if (countOne(res) == cnt_one)
                break;
        }
        return res;
    }

    private static int countOne(int num) {
        int cnt = 0;
        while (num != 0) {
            if (num % 2 == 1)
                cnt++;
            num /= 2;
        }
        return cnt;
    }
}
