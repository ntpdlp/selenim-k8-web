package test.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearnDataProvider {

    @Test(dataProvider = "usernameData")
    public void testDataProvider(User user){
        System.out.println(user);
    }

    @DataProvider
    public User[] usernameData(){
        User teo = new User("teo",5);
        User ti = new User("ti",15);
        User tun = new User("tun",25);

        return new User[]{teo,ti,tun};
    }


    public class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
