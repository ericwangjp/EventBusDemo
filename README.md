#EventBusDemo

##基于EventBus的简单封装demo，简化EventBus的注册以及调用，事件的快速创建及解析

EventBus git 地址：https://github.com/greenrobot/EventBus
AndroidStudio 使用前在app的build.gradle中添加依赖：
      implementation 'org.greenrobot:eventbus:3.1.1'

##封装后使用：
###事件的发送：
      EventBusUtil.sendStickyEvent(new Event(Constants.EventBusCode.EVENT_BUS_CODE_A));
###事件的接收：
事件可以在基类同一处理分发，也可以在对应的页面进行接收处理
在对应页面：
    @Override
    protected void receiveEvent(Event event) {
        super.receiveEvent(event);
        Log.e("接收到普通事件", getClass().getName() + "--->" + event.getCode() + "<---");
    }
 如果在基类处理，子类需要复写以下方法：
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
    
 ##注意：
  无论在哪里处理接收事件，都必须在需要接收事件的子类复写以下方法来开启EventBus的注册和注销功能，否则事件无法接收
    @Override
    protected boolean isRegisterEventBus() {
        return true; //true 开启注册，false 关闭注册
    }
