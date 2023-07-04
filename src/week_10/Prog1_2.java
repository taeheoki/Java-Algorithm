package src.week_10;
/**
 * 문제 이해: 발판을 일렬로 세워두고 이를 순서대로 밟아 높이가 h인 벽을 넘어서려한다.
 한번에 k만큼 점프할 수 있으며, 붙어있는 두 발판의 높이 차가 k 이하라면 두 발판 사이를 점프할 수 있다.
 높이가 제각기 다른 발판이 주어졌을 때, 벽을 넘어가기 위해 필요한 발판의 최소 개수를 구하라.
 */
import java.util.*;

class Prog1_2 {
    public int solution(int h, int k, int[] boxes) {
        int cnt = 0;
        // 발판을 넘어서기 전 정렬
        Arrays.sort(boxes);

        int height = 0;
        int pre = 0;
        int pre_height = 0;
        int i = 0;
        while (true) {
            pre_height = height;
            height = pre + k;
            if (pre_height == height) {
                cnt = 0;
                break;
            }
            cnt++;
            for (; i < boxes.length; i++) {
                if (height >= boxes[i]) {
                    pre = boxes[i];
                } else {
                    break;
                }
            }

            if (height >= h)
                break;
        }
        return cnt - 1;
    }
}