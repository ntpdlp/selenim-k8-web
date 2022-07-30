package modules.components.anotation;


public class AnnotationTest {


    //how to triger value() : Generic no-boundary/no-limit
    public <T> void getAnnotationComponent(Class<T> compClass){

        try{
            String value = compClass.getAnnotation(AnnotationCSSSelector.class).value();
            System.out.println(value);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AnnotationTest().getAnnotationComponent(LoginFormComponent.class);
    }
}
