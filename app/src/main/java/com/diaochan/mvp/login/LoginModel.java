package com.diaochan.mvp.login;

import com.diaochan.mvp.base.BaseModel;
import com.diaochan.mvp.bean.UserInfo;

public class LoginModel extends BaseModel<LoginPresenter,LoginContract.Model> {
    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void executeLogin(String name, String pwd) throws Exception {
                //模拟网络请求和校验
                if("diaochan".equals(name) && "89757".equals(pwd)){
                    UserInfo userInfo = new UserInfo("sina","wsj");
                    p.getContract().responseResult(userInfo);
                }else{
                    p.getContract().responseResult(null);
                }
            }
        };
    }
}
