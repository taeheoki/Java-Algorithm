package src.week_35;

/**
 * 프로그래머스 - 혼자 놀기의 달인
 */
public class Pro131130 {
    static int res;
    static boolean[] opened, opened2;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
    }

    public static int solution(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            opened = new boolean[cards.length];
            int index = i;
            int cnt = 0;
            while (!opened[index]) {
                opened[index] = true;
                index = cards[index] - 1;
                cnt++;
            }
            for (int j = 0; j < cards.length; j++) {
                opened2 = opened.clone();
                int secondIndex = j;
                int cnt2 = 0;
                while (!opened[secondIndex]) {
                    opened[secondIndex] = true;
                    secondIndex = cards[secondIndex] - 1;
                    cnt2++;
                }
                res = Math.max(res, cnt * cnt2);
            }

        }
        return res;
    }
}
