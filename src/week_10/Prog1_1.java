package src.week_10;

/**
 * 최대한 많은 수의 풀하우스를 만들어 보려한다. 풀하우스는 같은 숫자 3장과 다른 같은 숫자 2장으로 이루어진 카드 조합이다.
 * 카드를 한 장씩 순서대로 받습니다. 들고 있는 카드 중 5장을 이용해 풀하우스를 만든다면 점수를 1점 얻고, 들고 있던 모든 카드를 버립니다.
 * 들고 있는 카드로 2개 이상의 풀하우스를 만들더라도 한 번에 1점만 얻을 수 있고 가지고 있는 모든 카드를 버려야합니다.
 * 만일 조커를 가지고 있다면 어떤 카드로든 대체가능합니다.
 */
import java.util.*;

class Prog1_1 {
    static int ans;
    static int[] isHaved;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution(new int[] {11, 10, 0, 3, 0, 0, 10, 10, 11, 11}));
        System.out.println(solution(new int[] {0, 0, 0, 0, 0}));
        System.out.println(solution(new int[] {0, 0, 1, 0}));
        System.out.println(solution(new int[] {0, 0, 0, 1, 1}));
        System.out.println(solution(new int[] {0, 0, 1, 1, 1}));
        System.out.println(solution(new int[] {1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1}));
        System.out.println(solution(new int[] {0, 0, 1, 0, 2, 0, 0, 1, 2, 2}));
    }

    public static int solution(int[] cards) {
        ans = 0;
        isHaved = new int[14];
        for (int i = 0; i < cards.length; i++) {
            isHaved[cards[i]]++;
            arr.add(cards[i]);
            if (arr.size() >= 5)
                pro();
        }
        arr.clear();
        return ans;
    }

    private static void pro() {
        for (int i = 1; i <= 13; i++) {
            if (isHaved[i] >= 3) {
                for (int j = 1; j <= 13; j++) {
                    if (i != j && isHaved[j] >= 2) {
                        ans++;
                        clearCard();
                    }
                }
            }
        }
        if (isHaved[0] == 1) {
            for (int i = 1; i <= 13; i++) {
                if (isHaved[i] >= 3) {
                    for (int j = 1; j <= 13; j++) {
                        if (i != j && isHaved[j] >= 1) {
                            ans++;
                            clearCard();
                        }
                    }
                } else if (isHaved[i] >= 2) {
                    for (int j = 1; j <= 13; j++) {
                        if (i != j && isHaved[j] >= 2) {
                            ans++;
                            clearCard();
                        }
                    }
                }
            }
        } else if (isHaved[0] == 2) {
            for (int i = 1; i <= 13; i++) {
                if (isHaved[i] >= 3) {
                    ans++;
                    clearCard();
                }
                else if (isHaved[i] >= 2) {
                    for (int j = 1; j <= 13; j++) {
                        if (i != j && isHaved[j] >= 1) {
                            ans++;
                            clearCard();
                        }
                    }
                }
            }
        } else if (isHaved[0] == 3) {
            for (int i = 1; i <= 13; i++) {
                if (isHaved[i] >= 2) {
                    ans++;
                    clearCard();
                }
                else if (isHaved[i] >= 1) {
                    for (int j = 1; j <= 13; j++) {
                        if (i != j && isHaved[j] >= 1) {
                            ans++;
                            clearCard();
                        }
                    }
                }
            }
        } else if (isHaved[0] == 4) {
            for (int i = 1; i <= 13; i++) {
                if (isHaved[i] >= 1) {
                    ans++;
                    clearCard();
                }
            }
        } else if (isHaved[0] == 5) {
            ans++;
            clearCard();
        }
    }

    private static void clearCard() {
        for (int i = 0; i <= 13; i++) {
            isHaved[i] = 0;
        }
        arr.clear();
    }
}

