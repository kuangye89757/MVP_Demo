package com.diaochan.mvp.login;

import com.diaochan.mvp.LoginActivity;
import com.diaochan.mvp.base.BasePresenter;
import com.diaochan.mvp.bean.UserInfo;

public class LoginPresenter extends BasePresenter<LoginModel, LoginActivity, LoginContract.Presenter> {

    @Override
    public LoginContract.Presenter getContract() {
        //既要履行V层交给的任务，还要分配给M层去完成
        return new LoginContract.Presenter<UserInfo>() {
            @Override
            public void requestLogin(String name, String pwd) {
                try {
                    //第一种：交给M层去处理
                    m.getContract().executeLogin(name, pwd);

                    //第二种：交给library (网络下载，请求模块等)
                    //                    HttpEngine httpEngine = new HttpEngine(LoginPresenter.this);
                    //                    httpEngine.post(name, pwd);

                    //第三种：P层自己处理
                    //                    if("diaochan".equals(name) && "89757".equals(pwd)){
                    //                        UserInfo userInfo = new UserInfo("sina","wsj");
                    //                        responseResult(userInfo);
                    //                    }else{
                    //                        responseResult(null);
                    //                    }
                } catch (Exception e) {
                    //发生异常告知V层
                    if (getView() != null) {
                        getView().error(e);
                    }
                    e.printStackTrace();
                }
            }

            @Override
            public void responseResult(UserInfo userInfo) {
                if (getView() != null) {
                    getView().getContract().handleResult(userInfo);
                }
            }

        };
    }

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }
}
