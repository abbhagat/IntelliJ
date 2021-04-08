package shape;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Getter
@Setter
public class Triangle implements Shape, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private List<Point> points;

    @Autowired
    private MessageSource messageSource;

    private ApplicationContext applicationContext;

    public void draw() {
        System.out.println(this.getMessageSource().getMessage("triangle.type", null, "Drawing Default Triangle", null));
        this.points.forEach(point -> System.out.println("Point (" + point.getX() + "," + point.getY() + ")"));
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("BeanNameAware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean");
    }

    @Override
    public void destroy() {
        System.out.println("DisposableBean");
    }

    public void initTriangle() {
        System.out.println("MyInit");
    }

    public void destroyTriangle() {
        System.out.println("MyDestroy");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct");
    }

}
