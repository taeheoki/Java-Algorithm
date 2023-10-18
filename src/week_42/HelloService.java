package src.week_42;

public interface HelloService {
    // 인삿말
    String hello();
    static HelloService helloService(String message) {
        return new ChineseHelloService(message);
    }
}
