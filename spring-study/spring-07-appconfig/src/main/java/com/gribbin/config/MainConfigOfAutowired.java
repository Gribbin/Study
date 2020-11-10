package com.gribbin.config;

import com.gribbin.dao.BookDao;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配：
 *      Spring利用依赖注入(DI)，完成对IOC容器中各个组件的依赖关系赋值；
 *
 * 1、@Autowired:自动注入；
 *      1)、默认优先按照类型去容器中找对应的组件:context.getBean(BookDao.class),找到就赋值；
 *      2)、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *      3)、@Qualifier("bookDao"):使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 *      4)、自动装配默认一定要将属性赋值，没有就报错,可以使用@Autowired(required = false)不赋值
 *      5)、@Primary:让Spring进行自动装配时默认首选的bean;
 *              也可以使用@Qualifier指定需要装配的bean的名字
 *
 * 2、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)；[java规范组件]
 *      Resource:可以和@Autowired一样实现自动装配功能，默认按照组件名称进行装配；
 *              没有能支持@Primary和@Autowired(required = false)
 *      Inject:需要导入javax.inject包，和@Autowired功能一样,没有(required = false)功能
 *
 * 3、@Autowired:构造器、参数、方法、属性；
 *      1)、标注在方法上:标注在setter方法上或者@Bean+方法参数，参数从容器汇总获取，默认不写@Autowired
 *      2)、标注在有构造器上:如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略
 *      3)、放在参数位置
 *
 * 4、自定义组件想要使用Spring容器底层的一些组件(ApplicationContext,BeanFactory,XXX)
 *      自定义组件实现xxxAware接口:在创建对象的时候，会调用接口规定的方法注入相关组件；
 *      把Spring底层的一些组件注入到自定义的Bean中；
 *      xxxAware功能使用xxxProcessor实现；
 *
 * AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能；
 *
 * @Author gribbin
 * @create 2020/11/9 17:23
 */
@Configuration
@ComponentScan({"com.gribbin.dao", "com.gribbin.service", "com.gribbin.controller", "com.gribbin.pojo"})
public class MainConfigOfAutowired {
    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}
