
import org.junit.Test;
import org.zywang.myspring.PropertyValue;
import org.zywang.myspring.PropertyValues;
import org.zywang.myspring.factory.config.BeanDefinition;
import org.zywang.myspring.factory.config.BeanReference;
import org.zywang.myspring.factory.support.DefaultListableBeanFactory;
import org.zywang.myspring.factory.support.XmlBeanDefinitionReader;
import org.zywang.myspring.test.bean.bean.UserDao;
import org.zywang.myspring.test.bean.bean.UserService;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println(userService);
        userService.queryUserInfo();
    }

    @Test
    public void test_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();

    }

}
