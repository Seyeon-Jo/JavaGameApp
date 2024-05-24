package overloadedapp;

public class OverloadedMethods {

    public static int display(int a) {
        return a * 2;
    }

    public static double display(double a) {
        return a * a;
    }

    public static int display(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(display(5));
        System.out.println(display(10));
        System.out.println(display(3, 7));
    }
}
