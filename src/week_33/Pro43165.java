package src.week_33;

/**
 * 프로그래머스 - 타겟 넘버
 */
public class Pro43165 {

    static int res, n;
    static int[] arr;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }

    public static int solution(int[] numbers, int target) {
        n = numbers.length;
        arr = numbers;
        rec_func(0, 0, target);
        return res;
    }

    private static void rec_func(int depth, int num, int target) {
        if (depth == n) {
            if (num == target)
                res++;
            return;
        }
        rec_func(depth + 1, num + arr[depth], target);
        rec_func(depth + 1, num - arr[depth], target);
    }
}
