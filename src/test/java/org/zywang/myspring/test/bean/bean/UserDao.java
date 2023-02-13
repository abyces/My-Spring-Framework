package org.zywang.myspring.test.bean.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "a");
        hashMap.put("10002", "b");
        hashMap.put("10003", "c");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
