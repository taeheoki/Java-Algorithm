package src.week_42;

public class Test {
    public static void main(String[] args) {
        HelloService hello = HelloService.helloService("hello");
        System.out.println(hello.hello());
    }
}
