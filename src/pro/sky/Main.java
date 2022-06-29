package pro.sky;

public class Main {
    public static void main(String[] args) {
        boolean result = Validator.validate("test_1234", "123456", "123456");
        if (result){
            System.out.println("Login&Password are correct");
        } else {
            System.out.println("Login&Password are incorrect");
        }
    }
}