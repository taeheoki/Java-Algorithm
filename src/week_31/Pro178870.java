package src.week_31;

public class Pro178870 {
    // 투포인터 문제
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length - 1};
        int right = -1;
        int sum = 0;
        for (int left = 0; left < sequence.length; left++) {
            if (left != 0)
                sum -= sequence[left - 1];
            while (right + 1 < sequence.length && sum < k) {
                right++;
                sum += sequence[right];
            }
            if (sum == k) {
                int res = right - left;
                if (res < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        return answer;
    }
}
