import com.gribbin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //代理的接口，所以这里获取的是接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
