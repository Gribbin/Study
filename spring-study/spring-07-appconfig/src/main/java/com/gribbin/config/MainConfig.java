package com.gribbin.config;

import com.gribbin.condition.LinuxCondition;
import com.gribbin.condition.MyImportBeanDefinitionRegistrar;
import com.gribbin.condition.MyImportSelector;
import com.gribbin.condition.WindowsCondition;
import com.gribbin.pojo.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScans(value = {
        /*@ComponentScan(value = "com.gribbin", includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookMapper.class})
        }, useDefaultFilters = false),*/
        @ComponentScan(value = "com.gribbin", includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
})
//放在类上怎判断类中所有组件
@Conditional({WindowsCondition.class})
//导入组件，id默认是组件的全类名
@Import({Red.class, Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig {
    /**
     * Specifies the name of the scope to use for the annotated component/bean.
     * <p>Defaults to an empty string ({@code ""}) which implies
     * {@link ConfigurableBeanFactory#SCOPE_SINGLETON SCOPE_SINGLETON}.
     *
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     * <p>
     * prototype:多实例的，IOC容器启动并不会去调用方法创建对象，每次获取的时候才会调用方法创建对象；
     * singleton：单实例的(默认值)，IOC容器启动会调用方法创建对象放到IOC容器中，以后每次获取直接从容器中拿(map.get())；
     * request:同一次请求创建一个实例
     * session:同一个session创建一个实例
     * <p>
     * Lazy：单实例bean，默认在容器启动的时候创建对象，
     * 懒加载：容器启动不创建对象，第一次使用Bean创建并初始化
     * @since 4.2
     */
    @Lazy
    @Scope("singleton")
    @Bean("person")
    public Person person() {
        System.out.println("往容器中添加Person...");
        return new Person("cbb", 19);
    }

    /**
     * @Conditional{Condition}:按照一定的条件进行判断，满足条件才给容器中注入bean 如果放在类上则判断类中所有bean
     */
    @Conditional({WindowsCondition.class})
    @Bean("Bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("Linus")
    public Person person02() {
        return new Person("Linus Benedict Torvalds", 51);
    }

    /**
     * 给容器中注册组件：
     * 1、包扫描+组件标注注解（@Controller/@Service@Repository@Component）
     * 2、@Bean(导入的第三方包里的组件)
     * 3、@Import(快速给容器中导入一个组件)
     *                  1)、@Import(要导入到容器中的组件)：容器自动注册这些组件，id默认是全类名
     *                  2)、ImportSelector:返回需要导入的组件全类名数组
     *                  3)、ImportBeanDefinitionRegistrar:手动注册bean
     * 4、使用Spring提供的FactoryBean(工厂bean)
     *                  1)、工厂bean默认获取的是调用getObject()创建的对象
     *                  2)、要获取FactoryBean本身，需要在id前面加一个&(&colorFactoryBean)
     */
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
