package org.zywang.myspring.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("Running: init-method");
        hashMap.put("10001", "a");
        hashMap.put("10002", "b");
        hashMap.put("10003", "c");
    }

    public void destroyDataMethod() {
        System.out.println("Running: destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
