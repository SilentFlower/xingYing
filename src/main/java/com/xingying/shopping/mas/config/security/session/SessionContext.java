package com.xingying.shopping.mas.config.security.session;

/**
 * @author SiletFlower
 * @date 2021/3/26 09:08:40
 * @description
 */


import com.xingying.shopping.mas.common.utils.key.UuidUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * session上下文
 */
public class SessionContext {
    /**
     * 将所有的session保存到此哈希表中
     */
    private static ConcurrentHashMap<Serializable, MySession> sessions = new ConcurrentHashMap<>();

    public static Serializable create(MySession session) {

        String uuid = UuidUtil.createUuid();
        session.setId(uuid);
        //将uuid存入map中
        storeSession(uuid,session);
        return uuid;
    }

    public static MySession createSession(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        MySession mySession = new MySession();
        Serializable id = create(mySession);
        return mySession;
    }

    private static MySession storeSession(Serializable uuid, MySession session) {
        if (uuid == null) {
            throw new NullPointerException("id cannot be null");
        }else{
            return (MySession) sessions.putIfAbsent(uuid, session);
        }
    }
}
