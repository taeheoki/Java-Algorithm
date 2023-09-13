package src.week_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BOJ 3758 - KCPC
 */
public class BOJ3758 {
    static StringBuilder sb = new StringBuilder();
    static int T, n, k, t, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n];
            for (int i = 0; i < m; i++) {
                // 로그수만큼 반복
                st = new StringTokenizer(br.readLine());
                int teamID = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (teams[teamID - 1] == null) {
                    teams[teamID - 1] = new Team(teamID, new int[k + 1]);
                }

                teams[teamID - 1].scoreList[problemNum] = Math.max(score, teams[teamID - 1].scoreList[problemNum]);
                teams[teamID - 1].submitNum++;
                teams[teamID - 1].lastSubmit = i;
            }
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += teams[i].scoreList[j];
                }
                teams[i].totalScore = sum;
            }

            Arrays.sort(teams, (o1, o2) -> {
                if (o1.totalScore == o2.totalScore) {
                    if (o1.submitNum == o2.submitNum) {
                        return o1.lastSubmit - o2.lastSubmit;
                    }
                    return o1.submitNum - o2.submitNum;
                }
                return o2.totalScore - o1.totalScore;
            });

            for (int i = 0; i < n; i++) {
                if (teams[i].id == t) {
                    // 내 팀 찾음
                    sb.append(i + 1).append('\n');
                }
            }
        }
        System.out.println(sb);
    }

    private static class Team {
        int id;
        int[] scoreList;
        int submitNum;
        int lastSubmit;
        int totalScore;


        public Team(int teamID, int[] arr) {
            id = teamID;
            scoreList = arr;
        }
    }
}
