package src.week_12;

/**
 * 프로그래머스 - 124 나라의 숫자
 * 문제 이해: 124 나라에서는 숫자를 자신들만의 규칙으로 표현합니다.
 *          10진법 수를 3으로 나누며 그 배열로 지정한 위치의 1, 2, 4를 출력해주는 방식을 취한다.
 */
public class Pro124나라의숫자 {
    static StringBuilder sb;
    static char[] data = new char[]{'1', '2', '4'};


    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
        System.out.println(solution(9));
        System.out.println(solution(10));
        System.out.println(solution(11));
        System.out.println(solution(12));
        System.out.println(solution(13));
    }

    public static String solution(int n) {
        sb = new StringBuilder();
        n--;
        rec_func(n);
        return String.valueOf(sb);
    }

    private static void rec_func(int n) {
        if (n / 3 == 0) {
            sb.append(data[n % 3]);
        } else {
            rec_func((n / 3) - 1);
            sb.append(data[n % 3]);
        }
    }
}
