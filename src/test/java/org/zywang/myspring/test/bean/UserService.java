package org.zywang.myspring.test.bean;

public class UserService {
    private String uId;
    private String location;
    private String company;
    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println("query user info: " + userDao.queryUserName(uId));
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

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "uId='" + uId + '\'' +
                ", location='" + location + '\'' +
                ", company='" + company + '\'' +
                ", userDao=" + userDao +
                '}';
    }
}
