package src.week_17;

import java.util.*;

/**
 * 프로그래머스 - 오픈채팅방
 */
public class Pro오픈채팅방 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }

    public static String[] solution(String[] record) {
        ArrayList<String> tmp = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String cmd = st.nextToken();
            String id = st.nextToken();
            if (cmd.equals("Enter")) {
                String nickname = st.nextToken();
                map.put(id, nickname);
                tmp.add(id + "님이 들어왔습니다.");
            } else if (cmd.equals("Leave")) {
                tmp.add(id + "님이 나갔습니다.");
            } else {
                String nickname = st.nextToken();
                map.put(id, nickname);
            }
        }

        String[] ans = new String[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            int endPos = tmp.get(i).indexOf("님");
            String id = tmp.get(i).substring(0, endPos);
            String nickname = map.get(id);
            ans[i] = tmp.get(i).replace(id, nickname);
        }
        return ans;
    }
}
