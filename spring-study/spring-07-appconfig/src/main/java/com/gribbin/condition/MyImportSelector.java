package com.gribbin.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    /**
     * @param importingClassMetadata:当前标注@Import注解的类的所有注解信息
     * @return 返回全类名数组
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.gribbin.pojo.Yellow", "com.gribbin.pojo.Blue"};
    }
}
