package modules.components;

import java.lang.reflect.Constructor;

@L19AnnotationCSSSelector("#annotation-test")
public class L19AnnotationTest {


    //how to triger value() : Generic no-boundary/no-limit
    public <T> void executeAnnotation(Class<T> compClass){
        Class<?>[] parameters = new Class[]{};

        try{
            String value = compClass.getAnnotation(L19AnnotationCSSSelector.class).value();
            System.out.println(value);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new L19AnnotationTest().executeAnnotation(L19AnnotationTest.class);
    }
}
