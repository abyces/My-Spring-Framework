package org.zywang.myspring.test.bean.bean;

public class UserService {
    private String uId;
    private org.zywang.myspring.test.bean.bean.UserDao userDao;

    public void queryUserInfo() {
        System.out.println("query user info: " + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public org.zywang.myspring.test.bean.bean.UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(org.zywang.myspring.test.bean.bean.UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "uId='" + uId + '\'' +
                ", userDao=" + userDao +
                '}';
    }
}
