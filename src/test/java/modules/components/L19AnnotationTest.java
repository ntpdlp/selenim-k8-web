package modules.components;

import java.lang.reflect.Constructor;


public class L19AnnotationTest {


    //how to triger value() : Generic no-boundary/no-limit
    public <T> void getAnnotationComponent(Class<T> compClass){

        try{
            String value = compClass.getAnnotation(L19AnnotationCSSSelector.class).value();
            System.out.println(value);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new L19AnnotationTest().getAnnotationComponent(L19AnnotationTest.class);
    }
}
