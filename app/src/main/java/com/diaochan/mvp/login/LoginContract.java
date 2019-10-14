package com.diaochan.mvp.login;

import com.diaochan.mvp.bean.BaseEntity;

/**
 * 将M层、Presenter层、V层协商的共同业务，封装成接口（契约、合同）
 */
public interface LoginContract {

    interface Model{
        // 由Model的子类去实现具体登录逻辑------------2
        void executeLogin(String name,String pwd) throws Exception; 
    }

    
    interface View<T extends BaseEntity>{
        //真实的项目中，请求的结果以javaBean的形式返回------------4
        void handleResult(T t); 
    }
    
    
    interface Presenter<T extends BaseEntity>{
        
        //登录请求（接收到View层指令，可以自己做，也可以Model层去执行）------------1
        void requestLogin(String name,String pwd);
        
        //结果响应（接收到Model层处理的结果，再通知View层）------------3
        void responseResult(T t);
    }
}
