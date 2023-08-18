package src.week_32;

import java.util.*;

/**
 * 프로스래머스 - 표 편집
 */
public class Pro81303 {

    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
        System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
    }

    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> removed = new Stack<>();
        int arrSize = n;
        for (int i = 0; i < cmd.length; i++) {
            StringTokenizer st = new StringTokenizer(cmd[i]);
            switch(st.nextToken()) {
                case "U":
                    k -= Integer.parseInt(st.nextToken());
                    break;
                case "D":
                    k += Integer.parseInt(st.nextToken());
                    break;
                case "C":
                    removed.add(k);
                    arrSize--;
                    // last
                    if (k >= arrSize)
                        k--;
                    break;
                case "Z":
                    int z = removed.pop();
                    // 복구하는 인덱스가 현재보다 앞설때
                    if (z <= k)
                        k++;
                    arrSize++;
                    break;
                default:
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arrSize;i++) {
            sb.append('O');
        }
        while(!removed.isEmpty()) {
            int z = removed.pop();
            sb.insert(z,'X');
        }
        return sb.toString();
    }
}
