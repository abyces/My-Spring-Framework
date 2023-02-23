package org.zywang.myspring.test.bean;

import org.zywang.myspring.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "aaa, US, CA");
        hashMap.put("10002", "bbb, CHN, SH");
        hashMap.put("10003", "ccc, JPN, TK");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
