
import org.junit.Test;
import org.zywang.myspring.factory.config.BeanDefinition;
import org.zywang.myspring.factory.BeanFactory;
import org.zywang.myspring.factory.support.DefaultListableBeanFactory;
import org.zywang.myspring.test.bean.UserService;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService", "abc");
        System.out.println(userService);
        userService.queryUserInfo();
    }

}
