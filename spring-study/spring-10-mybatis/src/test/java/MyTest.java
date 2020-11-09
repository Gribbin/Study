import com.gribbin.dao.UserMapper;
import com.gribbin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = ctx.getBean("userMapper2", UserMapper.class);
        List<User> users = userMapper.getUserList();
        for (User user : users) {
            System.out.println(user);
        }
    }
}