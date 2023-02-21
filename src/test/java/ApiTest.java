
import org.junit.Test;
import org.zywang.myspring.beans.PropertyValue;
import org.zywang.myspring.beans.PropertyValues;
import org.zywang.myspring.beans.factory.config.BeanDefinition;
import org.zywang.myspring.beans.factory.config.BeanReference;
import org.zywang.myspring.beans.factory.support.DefaultListableBeanFactory;
import org.zywang.myspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.zywang.myspring.context.support.ClassPathXmlApplicationContext;
import org.zywang.myspring.test.bean.UserDao;
import org.zywang.myspring.test.bean.UserService;
import org.zywang.myspring.test.common.MyBeanFactoryPostProcessor;
import org.zywang.myspring.test.common.MyBeanPostProcessor;

import org.openjdk.jol.info.ClassLayout;
import org.zywang.myspring.test.event.CustomEvent;

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

    @Test
    public void test_BeanFactoryPostProcessAndBeanPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        System.out.println(userService);
    }

    @Test
    public void test_xml2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
    }

    @Test
    public void test_xml_initAndDestroyMethod() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
    }

    @Test
    public void test_xml_Aware() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
//        System.out.println("ApplicationContextAware: " + userService.getApplicationContext());
//        System.out.println("BeanFactoryAware: " + userService.getBeanFactory());
    }

    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_prototype.xml");
        applicationContext.registerShutdownHook();

        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);
        UserService userService03 = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService01);
        System.out.println(userService02);
        System.out.println(userService03);

        System.out.println(userService01 + " hashcode: " + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_prototype.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());
    }

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_event.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "succ."));
        applicationContext.registerShutdownHook();
    }

}
