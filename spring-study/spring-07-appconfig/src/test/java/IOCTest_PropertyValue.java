import com.gribbin.config.MainConfigOfPropertyValue;
import com.gribbin.pojo.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author gribbin
 * @create 2020/11/2 16:41
 */
public class IOCTest_PropertyValue {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);

    @Test
    public void test01() {
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}
