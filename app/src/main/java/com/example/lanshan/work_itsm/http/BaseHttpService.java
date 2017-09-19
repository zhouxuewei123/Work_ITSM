package com.example.lanshan.work_itsm.http;



import com.example.lanshan.work_itsm.model.bean.UserBean;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

/**
 * @Description:接口服务
 * @author: ragkan
 * @time: 2016/7/5 11:48
 */
public interface BaseHttpService {

    /**
     * 登录接口
     *
     */
    @FormUrlEncoded
    @POST("loginService/login")
    Call<UserBean> login(@Field("username") String username,
                         @Field("password") String password
    );
}


