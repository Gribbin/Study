package com.gribbin.config;

import com.gribbin.pojo.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * bean的生命周期：
 *      bean创建---初始化---销毁的过程
 * 容器管理bean的生命周期，我们可以自定义初始化和销毁方法；
 * 容器在bean进行到当前生命周期的时候来调用我们自定义的初始化合销毁方法；
 *
 * 构造(对象创建)
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 *
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 * BeanPostProcessor.postProcessAfterInitialization
 * 销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean，也不会调用销毁方法
 *
 * 遍历得到容器中所有的BeanPostProcessor，挨个执行beforeInitialization,
 * 一旦返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessBeforeInitialization方法
 *
 * BeanPostProcessor原理
 * populateBean(beanName, mbd, instanceWrapper); 对bean进行属性赋值
 * initializeBean(beanName, exposedObject, mbd);
 * {
 * applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * invokeInitMethods(beanName, wrappedBean, mbd); 执行自定义初始化方法
 * applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * }
 *
 * 1、指定初始化方法
 *      通过@Bean指定init-method和destroy-method
 * 2、通过让bean实现InitializingBean(初始化接口)和DisposableBean(销毁接口)
 * 3、可以使用JSR250：
 *      PostConstruct: 在bean创建完成并且属性赋值完成后执行初始化方法
 *      PreDestroy: 在容器销毁bean之前通知我们进行清理
 * 4、BeanPostProcessor:bean的后置处理器
 *      在bean初始化前后进行一些处理工作:
 *      postProcessBeforeInitialization:在初始化之前工作
 *      postProcessAfterInitialization:在初始化之后工作
 *
 * Spring底层对BeanPostProcessor的使用:
 *      bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async等等功能
 *      都是通过实现BeanPostProcessor接口实现的
 *
 * @author gribbin
 */
@ComponentScan(value = "com.gribbin.pojo")
public class MainConfigOfLifeCycle {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
