package pro.sky;

public class Validator {

    private static final String VALID_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    private Validator() {
    }

    public static boolean validate(String login,
                                   String password,
                                   String confirmPassword) {
        try {
            checkPasswordUsingLoop(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    private static void checkPasswordUsingLoop(String login,
                                      String password,
                                      String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Login must not be null or contain more than 20 symbols");
        }
        if (password == null || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Fields Password and ConfirmPassword must match");
        }
        if (password.length() >= 20) {
            throw new WrongPasswordException("Password must contain less that 20 symbols");
        }
        checkCharacters(login, "Login");
        checkCharacters(password, "Password");
    }
    private static void checkCharacters(String s, String what) throws WrongLoginException {
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
                throw new WrongLoginException(String.format("%s contains incorrect symbol %c! ", what, s.charAt(i)));
            }
        }
    }
}
