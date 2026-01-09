package shape;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public class Triangle implements Shape, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, ApplicationEventPublisherAware {

  private List<Point> points;

  @Autowired
  private MessageSource messageSource;

  private ApplicationContext applicationContext;

  private ApplicationEventPublisher applicationEventPublisher;

  public void draw() {
    System.out.println(this.getMessageSource().getMessage("triangle.type", new Object[]{"Equilateral", "Triangle"}, "Drawing Default Triangle", null));
    this.points.forEach(point -> System.out.println("Point (" + point.getX() + "," + point.getY() + ")"));
    MyAppEvent myAppEvent = new MyAppEvent(this);
    applicationEventPublisher.publishEvent(myAppEvent);
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

  @PostConstruct
  public void postConstruct() {
    System.out.println("@PostConstruct");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("@PreDestroy");
  }

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public List<Point> getPoints() {
    return points;
  }

  public void setPoints(List<Point> points) {
    this.points = points;
  }

  public MessageSource getMessageSource() {
    return messageSource;
  }

  public void setMessageSource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  public ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  public ApplicationEventPublisher getApplicationEventPublisher() {
    return applicationEventPublisher;
  }
}
