public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    public static void main(String[] args) {
        try {
            checkAuth("login","123","123");
            System.out.println("Все хорошо");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Регистрация не пройдена");
        }
    }
    private static void checkAuth(String login, String password, String confirmPassword)throws WrongLoginException,WrongPasswordException{
        if (!login.matches(REGEX) || login.length() > 20){
            throw new WrongLoginException("Логин неправильный");
        }
        if (!password.matches(REGEX) || password.length() > 20 || !password.equals(confirmPassword)){
            throw new WrongPasswordException();
        }
    }
}