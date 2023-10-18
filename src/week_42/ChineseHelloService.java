package src.week_42;

public class ChineseHelloService implements HelloService {
    private String message;

    public ChineseHelloService(String message) {
        this.message = message;
    }

    @Override
    public String hello() {
        return message;
    }
}
