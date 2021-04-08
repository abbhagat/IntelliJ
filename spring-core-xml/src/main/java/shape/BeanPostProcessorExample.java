package shape;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("triangle".equals(beanName)) {
            System.out.println("BeanPostProcessor -> postProcessBeforeInitialization() for " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("triangle".equals(beanName)) {
            System.out.println("BeanPostProcessor -> postProcessAfterInitialization() for " + beanName);
        }
        return bean;
    }
}
