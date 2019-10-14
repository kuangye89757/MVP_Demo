package com.diaochan.mvp.base;

import java.lang.ref.WeakReference;

/**
 * 协商M和V层
 */
public abstract class BasePresenter<M extends BaseModel, V extends BaseView, CONTRACT> {

    protected M m;

    //弱引用
    private WeakReference<V> mVWeakReference;

    /**
     * 弱引用绑定V层
     */
    public void bindView(V v) {
        mVWeakReference = new WeakReference<>(v);
    }

    //获取子类具体契约（View和Model的共同业务）
    public abstract CONTRACT getContract();


    /**
     * 获取View
     */
    public V getView() {
        if (mVWeakReference != null) {
            return mVWeakReference.get();
        }
        return null;
    }

    /** 
     * 获取Model
     */
    public abstract M getModel();

    public BasePresenter() {
        this.m = getModel();
    }

    /**
     * 解除与V层的绑定
     */
    public void unbindView() {
        if (mVWeakReference != null) {
            mVWeakReference.clear();
            mVWeakReference = null;
            System.gc();
        }
    }
}
