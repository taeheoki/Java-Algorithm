package src.codingtest_3;

import java.util.*;

public class Pro3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"desktop1 request", "desktop2 request", "desktop3 request", "desktop4 request", "desktop4 request", "desktop3 release", "desktop4 request", "desktop2 release", "desktop3 request"})));
        System.out.println(Arrays.toString(solution(3, new String[]{"desktop3 request", "desktop2 request", "desktop1 request", "desktop3 release", "desktop2 release", "desktop1 release", "desktop1 request", "desktop2 request", "desktop3 request"})));
    }

    public static String[] solution(int n, String[] queries) {
        ArrayList<String> arr = new ArrayList<>();
        Map<String, Com> coms = new HashMap<>();
        boolean[] used = new boolean[n + 1];

        for (int i = 0; i < queries.length; i++) {
            StringTokenizer st = new StringTokenizer(queries[i]);
            String name = st.nextToken();
            String cmd = st.nextToken();
            if (cmd.equals("request")) {
                if (!coms.containsKey(name)) {
                    int ip = -1;
                    for (int j = 1; j <= n; j++) {
                        if (!used[j]) {
                            used[j] = true;
                            ip = j;
                            break;
                        }
                    }
                    if (ip != -1) {
                        coms.put(name, new Com(ip, ip));
                        arr.add(name + " 192.168.0." + ip);
                    } else {
                        arr.add(name + " reject");
                    }
                } else {
                    int prevIp = coms.get(name).prevIp;
                    if (!used[prevIp]) {
                        used[prevIp] = true;
                        arr.add(name + " 192.168.0." + prevIp);
                    } else {
                        int ip = -1;
                        for (int j = 1; j <= n; j++) {
                            if (!used[j]) {
                                used[j] = true;
                                ip = j;
                                break;
                            }
                        }
                        if (ip != -1) {
                            coms.put(name, new Com(ip, ip));
                            arr.add(name + " 192.168.0." + ip);
                        } else {
                            arr.add(name + " reject");
                        }
                    }
                }
            } else {
                used[coms.get(name).ip] = false;
            }
        }

        String[] ans = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        System.out.println(Arrays.toString(used));
        return ans;
    }

    private static class Com {
        int ip;
        int prevIp;

        public Com(int ip, int prevIp) {
            this.ip = ip;
            this.prevIp = prevIp;
        }
    }

}
