package src.week_14;

/**
 * 프로그래머스 - N개의 최소공배수
 * 문제 이해: a와 b의 최소공배수 구하기
 *          유클리드 호제법을 이용하여 최대 공약수를 구하고,
 */
public class ProN개의최소공배수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14}));
        System.out.println(solution(new int[]{1, 2, 3}));
    }

    public static int solution(int[] arr) {
        int answer = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            answer = answer * arr[i] / lcm(answer, arr[i]);
        }
        return answer;
    }

    private static int lcm(int a, int b) {
        if (a % b == 0)
            return b;
        return lcm(b, a % b);
    }
}
