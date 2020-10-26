package com.gribbin.condition;

import com.gribbin.pojo.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata:当前类的注解信息
     * @param registry:BeanDefinition注册类      把所有需要添加到容器中的bean，调用
     *                                        BeanDefinitionRegistry.registerBeanDefinition手工注册
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b1 = registry.containsBeanDefinition("com.gribbin.pojo.Red");
        boolean b2 = registry.containsBeanDefinition("com.gribbin.pojo.Blue");
        if (b1 && b2) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}
