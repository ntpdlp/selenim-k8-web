package modules.components.GenericComponents;

import java.lang.reflect.Constructor;

public class LoginPageController {

    public <T extends LoginPage> void login(Class<T> loginPageClass){
        Class<?>[] parameters = new Class[]{};

        try{
            Constructor<T> constructor = loginPageClass.getConstructor(parameters);
            T curInstance = constructor.newInstance();
            System.out.println(loginPageClass.getSimpleName() + "================" ); //print runtime class name
            curInstance.login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new LoginPageController().login(LoginPageQA.class);
        new LoginPageController().login(LoginPageUAT.class);

    }
}
