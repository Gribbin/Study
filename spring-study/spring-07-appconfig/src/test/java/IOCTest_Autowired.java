import com.gribbin.config.MainConfigOfAutowired;
import com.gribbin.pojo.Red;
import com.gribbin.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService);

        //BookDao bookDao = context.getBean(BookDao.class);
        //System.out.println(bookDao);
        context.close();
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        Red red = context.getBean(Red.class);
        System.out.println(red);

        context.close();
    }
}
