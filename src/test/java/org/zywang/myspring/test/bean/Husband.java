package org.zywang.myspring.test.bean;

public class Husband {

    private Wife wife;

    public String queryWife() {
        return "Husband.wife";
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public Wife getWife() {
        return wife;
    }
}
