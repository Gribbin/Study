import com.gribbin.config.MainConfig;
import com.gribbin.config.SpringConfig;
import com.gribbin.pojo.Person;
import com.gribbin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class MyTest {

    //输出容器中的bean Name
    public void printBeans(ApplicationContext context) {
        //输出容器中的bean Name
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        printBeans(context);
    }

    @Test
    public void test02() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("IOC容器创建完成...");
        Person person1 = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);
        System.out.println(person1 == person2);
    }

    @Test
    public void test03() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Environment environment = context.getEnvironment();
        //测试时可以在虚拟机参数中指定操作系统名（-Dos.name=linux）
        String osName = environment.getProperty("os.name");
        System.out.println(osName);

        printBeans(context);
    }

    @Test
    public void test04() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        //工厂bean获取的是调用getObject()创建的对象
        Object bean1 = context.getBean("colorFactoryBean");
        Object bean2 = context.getBean("colorFactoryBean");
        System.out.println("bean的类型：" + bean1.getClass());
        System.out.println(bean1 == bean2);

        Object bean3 = context.getBean("&colorFactoryBean");
        System.out.println("bean的类型：" + bean3.getClass());
    }
}
