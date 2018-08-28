package com.luohuasheng.config;

import com.luohuasheng.annotation.EnableSwagger2;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.Map;

@Configuration
public class SwaggerInfoConfig implements ImportBeanDefinitionRegistrar {
    private static final String API_BEAN_NAME = "swaggerInfo";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        if (!beanDefinitionRegistry.containsBeanDefinition(API_BEAN_NAME)) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
                    .genericBeanDefinition(SwaggerInfo.class);
            AnnotationAttributes attributes = AnnotationAttributes.fromMap(
                    annotationMetadata.getAnnotationAttributes(EnableSwagger2.class.getName()));
            for (Map.Entry<String, Object> stringObjectEntry : attributes.entrySet()) {
                String key = stringObjectEntry.getKey();
                Object value = stringObjectEntry.getValue();
                if (value != null && !(value instanceof String && StringUtils.isEmpty(value))) {
                    beanDefinitionBuilder.addPropertyValue(key, value);
                }
            }
            beanDefinitionRegistry.registerBeanDefinition(API_BEAN_NAME, beanDefinitionBuilder.getBeanDefinition());
        }
    }


}
