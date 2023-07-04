package src.week_15;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 프로그래머스 - 영어 끝말잇기
 * 문제 이해: 끝말잇기를 진행하는데, 가장 먼저 탈락하는 사람의 번호와
 *          그 사람이 자신의 몇 번째 차례에서 탈락하는지 알아보자.
 */
public class Pro영어끝말잇기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));

    }

    public static int[] solution(int n, String[] words) {

        ArrayList<String> arr = new ArrayList<>();
        int[] answer = {0, 0};
        for (int i = 0; i < words.length; i++) {
            if (arr.contains(words[i]) || (i >= 1 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            arr.add(words[i]);
        }
        return answer;
    }
}
