import com.gribbin.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {
    @Test
    public void test01() {
        //创建一个ApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //设置需要激活的环境
        context.getEnvironment().setActiveProfiles("test", "dev");
        //注册主配置类
        context.register(MainConfigOfProfile.class);
        //启动刷新容器
        context.refresh();

        String[] names = context.getBeanNamesForType(DataSource.class);
        for (String name : names) {
            System.out.println(name);
        }

        context.close();
    }
}
