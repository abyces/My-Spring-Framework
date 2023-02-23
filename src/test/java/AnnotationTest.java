import org.junit.Test;
import org.zywang.myspring.context.support.ClassPathXmlApplicationContext;
import org.zywang.myspring.test.bean.IUserService;

public class AnnotationTest {

    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService);
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService);
    }

    /**
     * 切记在ClasspathBeanDefinitionScanner中，
     * 注册处理注解的 BeanPostProcessor（@Autowired、@Value）
     * -- AutowiredAnnotationBeanPostProcessor (extends InstantiationAwareBeanPostProcessor).
     */
    @Test
    public void test_autowired_value() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService.queryUserInfo());
    }

    @Test
    public void test_autoProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_advice.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService.queryUserInfo());
    }

}
