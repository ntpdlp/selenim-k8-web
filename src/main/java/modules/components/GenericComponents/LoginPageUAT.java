package modules.components.GenericComponents;

public class LoginPageUAT extends LoginPage{
    @Override
    public String username() {
        return "UAT username";
    }

    @Override
    public String password() {
        return "UAT password";
    }

    @Override
    public String loginBtn() {
        return "UAT loginBtn";
    }
}
