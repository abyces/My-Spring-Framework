package org.zywang.myspring.context.annotation;

import org.zywang.myspring.beans.factory.config.BeanDefinition;
import org.zywang.myspring.stereotype.Component;
import cn.hutool.core.util.ClassUtil;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 配置文件中提供 basePackage 路径
 * 自动扫描所有带 @Componenet 注解的对象
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);

        for (Class<?> clazz: classes) {
            candidates.add(new BeanDefinition(clazz));
        }

        return candidates;
    }

}
