package com.example.eventbusdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.eventbusdemo.event.Event;
import com.example.eventbusdemo.util.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * [类说明]:
 *
 * @author :wjp
 * @version :Vx.x.x
 * @date :2019/5/10
 */
public abstract class CommonBaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
    }

    /**
     * 是否需要在当前界面注册EventBus
     * 默认不需要
     * 子类可复写此方法
     *
     * @return
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    /**
     * 也可在子类实现，父类不实现
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveEventBus(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    /**
     * 也可在子类实现，父类不实现
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReceiveStickyEventBus(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 子类复写该方法获取接收到的粘滞事件
     *
     * @param event
     */
    protected void receiveStickyEvent(Event event) {

    }

    /**
     * 子类复写该方法获取接收到的普通事件
     *
     * @param event
     */
    protected void receiveEvent(Event event) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
    }
}
