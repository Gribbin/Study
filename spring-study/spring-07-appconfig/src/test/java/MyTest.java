import com.gribbin.config.MainConfig;
import com.gribbin.config.SpringConfig;
import com.gribbin.pojo.Person;
import com.gribbin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test02() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("IOC容器创建完成...");
        Person person1 = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);
        System.out.println(person1 == person2);
    }
}
