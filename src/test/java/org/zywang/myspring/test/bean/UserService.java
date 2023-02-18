package org.zywang.myspring.test.bean;

import org.zywang.myspring.beans.factory.*;
import org.zywang.myspring.context.ApplicationContext;
import org.zywang.myspring.context.ApplicationContextAware;

/**
 * UserService used for testing prototype
 */
public class UserService {
    private String uId;
    private String location;
    private String company;
    private IUserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + ", " + company + ", " + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}


/**
 * UserService used for testing before prototype;
 */
//public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {
//    private String uId;
//    private String location;
//    private String company;
//    private UserDao userDao;
//    private ApplicationContext applicationContext;
//    private BeanFactory beanFactory;
//
//    public void queryUserInfo() {
//        System.out.println("query user info: " + userDao.queryUserName(uId));
//    }
//
//    public String getuId() {
//        return uId;
//    }
//
//    public void setuId(String uId) {
//        this.uId = uId;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getCompany() {
//        return company;
//    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }
//
//    public UserDao getUserDao() {
//        return userDao;
//    }
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    public ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) {
//        this.beanFactory = beanFactory;
//    }
//
//    public BeanFactory getBeanFactory() {
//        return beanFactory;
//    }
//
//    @Override
//    public void setBeanClassLoader(ClassLoader classLoader) {
//        System.out.println("ClassLoader: " + classLoader);
//    }
//
//    @Override
//    public void setBeanName(String name) {
//        System.out.println("Bean name is: " + name);
//    }
//
//    @Override
//    public String toString() {
//        return "UserService{" +
//                "uId='" + uId + '\'' +
//                ", location='" + location + '\'' +
//                ", company='" + company + '\'' +
//                ", userDao=" + userDao +
//                '}';
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("Running: UserService.destroy");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Running: UserService.afterPropertiesSet");
//    }
//}


