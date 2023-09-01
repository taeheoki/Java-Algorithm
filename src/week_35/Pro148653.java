package src.week_35;

/**
 * 프로그래머스 - 마법의 엘리베이터
 */
public class Pro148653 {
    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
        System.out.println(solution(100000000));
        System.out.println(solution(94444445));
    }

    public static int solution(int storey) {
        int res = 0;

        while (storey > 0) {
            int num = storey % 10;
            storey /= 10;

            if (num > 5) {
                res += 10 - num;
                storey++;
            } else if (num < 5) {
                res += num;
            } else if (num == 5) {
                if (storey % 10 >= 5) {
                    res += 10 - num;
                    storey++;
                } else {
                    res += num;
                }
            }
        }
        return res;
    }
}
