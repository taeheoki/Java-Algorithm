package src.week_42;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public enum Card {
    SAMSUNG("삼성카드",money->(money/100)),  //CARD.SAMSUNG 으로 접근가능함(public static final 필드)
    KAKAO("카카오카드",money->(money*2/100)),
    HYUNDAI("현대카드",money->(money*3/100));

    private String name; //data를 가질수있다.
    private Function<Long,Long> point;

    Card(String name,Function<Long,Long> point) { //해당 생성자는 private 입니다 생략되어있음
        this.name = name;
        this.point=point;
    }

    public String getName() {
        return name;
    }
    public Long payBack(Long money){  //method를 가질수 있다
        return point.apply(money);
    }

    public static void main(String[] args) {
        // 새로운 EnumMap 생성
        EnumMap<Card, String> cardOwners = new EnumMap<>(Card.class);

        // 값 추가
        cardOwners.put(Card.SAMSUNG, "Alice");
        cardOwners.put(Card.KAKAO, "Bob");
        cardOwners.put(Card.HYUNDAI, "Charlie");

        // 전체 Map 출력
        System.out.println(cardOwners);

        System.out.println(cardOwners.get(Card.SAMSUNG));  // Alice 출력

        for (Map.Entry<Card,String> entry : cardOwners.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
