package com.gribbin.config;

import com.gribbin.pojo.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 *
 */
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
public class MainConfig {
    /**
     * Specifies the name of the scope to use for the annotated component/bean.
     * <p>Defaults to an empty string ({@code ""}) which implies
     * {@link ConfigurableBeanFactory#SCOPE_SINGLETON SCOPE_SINGLETON}.
     * @since 4.2
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * prototype:多实例的，IOC容器启动并不会去调用方法创建对象，每次获取的时候才会调用方法创建对象；
     * singleton：单实例的(默认值)，IOC容器启动会调用方法创建对象放到IOC容器中，以后每次获取直接从容器中拿(map.get())；
     * request:同一次请求创建一个实例
     * session:同一个session创建一个实例
     *
     * Lazy：单实例bean，默认在容器启动的时候创建对象，
     *                  懒加载：容器启动不创建对象，第一次使用Bean创建并初始化
     */
    @Lazy
    @Scope("singleton")
    @Bean("person")
    public Person person() {
        System.out.println("往容器中添加Person...");
        return new Person("cbb", 19);
    }
}
