package com.example.lanshan.work_itsm.http;

import com.MainApplication;
import com.android.core.model.api.HttpClient;
import java.util.HashMap;
import java.util.Map;


/**
 * @Description:
 * @author: ragkan
 * @time: 2016/7/5 13:48
 */
public class Factory {

    public static BaseHttpService provideHttpService() {
        return provideService(BaseHttpService.class);
    }

    private static Map<Class, Object> m_service = new HashMap();

    private static <T> T provideService(Class cls) {
        Object serv = m_service.get(cls);
        if (serv == null) {
            synchronized (cls) {
                serv = m_service.get(cls);
                if (serv == null) {//Const.BASE_URL
                    serv = HttpClient.getIns(MainApplication.mBaseUrl).createService(cls);
                    m_service.put(cls, serv);
                }
            }
        }
        return (T) serv;
    }
}
