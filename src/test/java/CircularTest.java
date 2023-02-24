import org.junit.Test;
import org.zywang.myspring.context.support.ClassPathXmlApplicationContext;
import org.zywang.myspring.test.bean.Husband;
import org.zywang.myspring.test.bean.Wife;

public class CircularTest {

    @Test
    public void test_circular() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-circular.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());
    }

}
