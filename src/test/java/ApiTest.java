
import org.junit.Test;
import org.zywang.myspring.BeanDefinition;
import org.zywang.myspring.BeanFactory;
import org.zywang.myspring.test.bean.UserService;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
