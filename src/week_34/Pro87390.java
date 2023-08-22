package src.week_34;

/**
 * 프로그래머스 - n^2 배열 자르기
 */
public class Pro87390 {
    public static void main(String[] args) {
        System.out.println(solution(3, 2, 5));
        System.out.println(solution(4, 7, 14));
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        for (long i = left; i <= right; i++) {
            answer[(int) (i - left)] = Math.max((int) (i / n), (int) (i % n)) + 1;
        }
        return answer;
    }
}
