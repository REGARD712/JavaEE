package com.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName: MyImportSelector
 * @Author: JacksonLee
 * @Date: 2026/8/27
 * @Description: 模拟实现Spring自动配置
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.config.AutoConfig", "com.config.AutoConfig2"};
    }
}
