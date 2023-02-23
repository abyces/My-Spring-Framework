package org.zywang.myspring.test.bean;

import org.zywang.myspring.aop.Pointcut;
import org.zywang.myspring.beans.factory.*;
import org.zywang.myspring.beans.factory.annotation.Autowired;
import org.zywang.myspring.beans.factory.annotation.Value;
import org.zywang.myspring.context.ApplicationContext;
import org.zywang.myspring.context.ApplicationContextAware;
import org.zywang.myspring.stereotype.Component;

import java.util.Random;


/**
 * UserService used for testing AOP
 */
@Component("userService")
public class UserService implements IUserService {

    @Value("${token}")
    private String token;

    @Autowired
    private UserDao userDao;

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return userDao.queryUserName("10001") + ", " + token;
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "register: " + userName + " succ.";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "token='" + token + '\'' +
                '}';
    }
}
