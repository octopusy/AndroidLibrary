package com.android.baseline.framework.ui.base;

import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.android.baseline.framework.ui.base.annotations.ViewUtils;

/**
 * 基类Activity, 提供业务逻辑的处理和深层的UI处理 
 * 1、实现View初始化、事件绑定 
 * 2、提供EventBus事件通知
 * @author hiphonezhu@gmail.com
 * @version [Android-BaseLine, 2014-9-15]
 */
public abstract class BaseActivity extends FragmentActivity
{
    @Override
    public void setContentView(int layoutResID)
    {
        super.setContentView(layoutResID);
        afterSetContentView();
    }

    @Override
    public void setContentView(View view)
    {
        super.setContentView(view);
        afterSetContentView();
    }

    @Override
    public void setContentView(View view, LayoutParams params)
    {
        super.setContentView(view,
                params);
        afterSetContentView();
    }
    
    /**
     * setContentView之后调用, 进行view的初始化等操作
     */
    private void afterSetContentView()
    {
        ViewUtils.inject(this);
        init();
    }
    
    /**
     * 不希望使用默认的注解来初始化View
     */
    protected void init()
    {
        
    }

    /**
     * EventBus订阅者事件通知的函数, UI线程
     * 
     * @param msg
     */
    public void onEventMainThread(Message msg)
    {
        onResponse(msg);
    }
    
    public abstract void onResponse(Message msg);
}
