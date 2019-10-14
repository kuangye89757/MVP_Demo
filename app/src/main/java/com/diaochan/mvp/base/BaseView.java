package com.diaochan.mvp.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 需要让P层去处理它的需求，并根据不同契约做不同处理
 */
public abstract class BaseView<P extends BasePresenter,CONTRACT> extends Activity {
    
    protected P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = getPresenter();
        //绑定View
        p.bindView(this);
    }

    public abstract CONTRACT getContract();
    
    // 由子类获取具体P层
    public abstract P getPresenter();

    // 发生异常的处理，通知给V层
    public void error(Exception e){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑View
        p.unbindView();
    }
}
