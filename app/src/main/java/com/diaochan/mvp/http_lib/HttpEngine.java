package com.diaochan.mvp.http_lib;


import com.diaochan.mvp.bean.UserInfo;
import com.diaochan.mvp.login.LoginPresenter;

// 有可能是共有的Model
public class HttpEngine<P extends LoginPresenter> {

    private P p;

    public HttpEngine(P p) {
        this.p = p;
    }

    public void post(String name, String pwd) {
        if("diaochan".equals(name) && "89757".equals(pwd)){
            UserInfo userInfo = new UserInfo("sina","wsj");
            p.getContract().responseResult(userInfo);
        }else{
            p.getContract().responseResult(null);
        }
    }
}
