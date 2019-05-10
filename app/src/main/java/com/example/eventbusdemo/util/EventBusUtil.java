package com.example.eventbusdemo.util;

import com.example.eventbusdemo.event.Event;

import org.greenrobot.eventbus.EventBus;

/**
 * [类说明]:
 *
 * @author :wjp
 * @version :Vx.x.x
 * @date :2019/5/10
 */
public class EventBusUtil {
    /**
     * 注册EventBus
     *
     * @param subscriber
     */
    public static void register(Object subscriber) {
        if (!isEventBusRegistered(subscriber)) {
            EventBus.getDefault().register(subscriber);
        }
    }

    /**
     * 取消EventBus注册
     *
     * @param subscriber
     */
    public static void unregister(Object subscriber) {
        if (isEventBusRegistered(subscriber)) {
            EventBus.getDefault().unregister(subscriber);
        }
    }

    /**
     * 发送普通事件
     *
     * @param event
     */
    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    /**
     * 发送粘滞事件
     *
     * @param event
     */
    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }

    /**
     * 当前界面是否已经注册EventBus
     *
     * @param subscriber
     * @return
     */
    public static boolean isEventBusRegistered(Object subscriber) {
        return EventBus.getDefault().isRegistered(subscriber);
    }

    /**
     * 获取已发送的粘滞事件
     *
     * @param eventType
     * @param <T>
     * @return
     */
    public static <T> T getStickEvent(Class<T> eventType) {
        return EventBus.getDefault().getStickyEvent(eventType);
    }

    /**
     * 移除粘滞事件
     *
     * @param eventType 需要移除的事件类型
     * @param <T>
     * @return
     */
    public <T> T removeStickEvent(Class<T> eventType) {
        return EventBus.getDefault().removeStickyEvent(eventType);
    }

    /**
     * 移除粘滞事件
     *
     * @param event 需要移除的事件对象
     * @return
     */
    public boolean removeStickEvent(Object event) {
        return EventBus.getDefault().removeStickyEvent(event);
    }

    /**
     * 移除所有的粘滞事件
     */
    public void removeAllStickEvent() {
        EventBus.getDefault().removeAllStickyEvents();
    }
}
