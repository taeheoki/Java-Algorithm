package src.week_31;

import java.util.Stack;

/**
 * 프로그래머스 - 택배 배달과 수거하기
 */
public class Pro150369 {

    public static void main(String[] args) {
        Pro150369 pro150369 = new Pro150369();
        System.out.println(pro150369.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> stackDel = new Stack<>();
        Stack<Integer> stackPick = new Stack<>();


        for (int i = 0; i < n; i++) {
            //deliveries 배열 중 배달해야하는 집의 index를 stackDel에 저장
            if (deliveries[i] != 0) {
                stackDel.push(i);
            }

            //pickups 배열 중 배달해야하는 집의 index를 stackDel에 저장
            if (pickups[i] != 0) {
                stackPick.push(i);
            }
        }

        int cntDel = cap;
        int cntPick = cap;

        //stackDel과 stackPick가 비어있지 않을 경우
        while (!stackDel.isEmpty() && !stackPick.isEmpty()) {
            answer += (stackDel.peek() > stackPick.peek()) ? 2 * (stackDel.peek() + 1) : 2 * (stackPick.peek() + 1);
            //cap 만큼 stack 요소 pop or update
            while (cntDel > 0 && !stackDel.isEmpty()) {
                int num = deliveries[stackDel.peek()];
                //현재 집의 모든 택배를 배달할 수 있는 경우, stack pop
                if (cntDel >= num) {
                    cntDel = cntDel - num;
                    stackDel.pop();
                //현재 집의 모든 택비를 배달할 수는 없는 경우, stack update
                } else {
                    deliveries[stackDel.peek()] = num - cntDel;
                    cntDel = 0;
                }
            }
            //수거해야할 것은 없지만, 배달해야할 것이 남은 경우
            while (cntPick > 0 && !stackPick.isEmpty()) {
                int num = pickups[stackPick.peek()];
                if (cntPick >= num) {
                    cntPick = cntPick - num;
                    if (!stackPick.isEmpty()) {
                        stackPick.pop();
                    }
                } else {
                    pickups[stackPick.peek()] = num - cntPick;
                    cntPick = 0;
                }
            }
            cntDel = cap;
            cntPick = cap;
        }

        //배달해야할 것은 없지만, 수거해야할 것이 남은 경우
        while (!stackDel.isEmpty()) {
            answer += 2 * (stackDel.peek() + 1);
            while (cntDel > 0 && !stackDel.isEmpty()) {
                int num = deliveries[stackDel.peek()];
                if (cntDel >= num) {
                    cntDel = cntDel - num;
                    if (!stackDel.isEmpty()) stackDel.pop();
                } else {
                    deliveries[stackDel.peek()] = num - cntDel;
                    cntDel = 0;
                }
            }
            cntDel = cap;
        }
        while (!stackPick.isEmpty()) {
            answer += 2 * (stackPick.peek() + 1);
            while (cntPick > 0 && !stackPick.isEmpty()) {
                int num = pickups[stackPick.peek()];
                if (cntPick >= num) {
                    cntPick = cntPick - num;
                    if (!stackPick.isEmpty()) stackPick.pop();
                } else {
                    pickups[stackPick.peek()] = num - cntPick;
                    cntPick = 0;
                }
            }
            cntPick = cap;
        }
        return answer;
    }
}
