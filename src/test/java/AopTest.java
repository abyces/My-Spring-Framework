import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import org.zywang.myspring.aop.AdvisedSupport;
import org.zywang.myspring.aop.MethodMatcher;
import org.zywang.myspring.aop.TargetSource;
import org.zywang.myspring.aop.aspectj.AspectJExpressionPointcut;
import org.zywang.myspring.aop.framework.Cglib2AopProxy;
import org.zywang.myspring.aop.framework.JdkDynamicAopProxy;
import org.zywang.myspring.aop.framework.ReflectiveMethodInvocation;
import org.zywang.myspring.context.support.ClassPathXmlApplicationContext;
import org.zywang.myspring.test.bean.IUserService;
import org.zywang.myspring.test.bean.UserService;
import org.zywang.myspring.test.bean.UserServiceInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AopTest {

    @Test
    public void test_aop_matcher() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* org.zywang.myspring.test.bean.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }


    /**
     * This test reflects what we have done
     * in org.zywang.myspring.aop.*
     */
    @Test
    public void test_proxy_method() {
        // 目标对象(可以替换成任何的目标对象)
        Object targetObj = new UserService();

        // AOP 代理
        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            // 方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.zywang.myspring.test.bean.IUserService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    // 方法拦截器
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("----------------------- AOP start -----------------------");
                            System.out.println("Method Name: " + invocation.getMethod());
                            System.out.println("Time cost: " + (System.currentTimeMillis() - start) + " ms");
                            System.out.println("------------------------ AOP end ------------------------");
                        }
                    };
                    // 反射调用
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });

        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);

    }

    @Test
    public void test_dynamic() {
        IUserService userService = new UserService();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* org.zywang.myspring.test.bean.IUserService.*(..))"));
//        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* org.zywang.myspring.test.bean.IUserService.queryUserInfo())"));

        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("Testing JDK: " + proxy_jdk.queryUserInfo());
        System.out.println("Testing JDK: " + proxy_jdk.register("abc"));

        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("Testing Cglib: " + proxy_cglib.queryUserInfo());
        System.out.println("Testing Cglib: " + proxy_cglib.register("cba"));
    }

    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_advice.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService.queryUserInfo());
    }

}
