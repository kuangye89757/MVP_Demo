package com.diaochan.mvp.base;

/**
 * 接收P层交给它的需求
 *      注意：不同业务有不同契约，所以要返回契约
 */
public abstract class BaseModel<P extends BasePresenter,CONTRACT> {
    
    protected P p;

    public BaseModel(P p) {
        this.p = p;
    }

    //业务结束通过Presenter调用契约、合同（接口中的方法 void responseResult(T t);）
        
    public abstract CONTRACT getContract();    
}
