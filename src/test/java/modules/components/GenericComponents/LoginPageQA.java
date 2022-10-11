package modules.components.GenericComponents;

public class LoginPageQA extends LoginPage{
    @Override
    public String username() {
        return "QA username";
    }

    @Override
    public String password() {
        return "QA password";
    }

    @Override
    public String loginBtn() {
        return "QA loginBtn";
    }
}
