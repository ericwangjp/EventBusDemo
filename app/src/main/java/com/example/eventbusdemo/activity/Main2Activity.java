package com.example.eventbusdemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.eventbusdemo.R;
import com.example.eventbusdemo.base.CommonBaseActivity;
import com.example.eventbusdemo.config.Constants;
import com.example.eventbusdemo.event.Event;
import com.example.eventbusdemo.util.EventBusUtil;

public class Main2Activity extends CommonBaseActivity {

    private Button btnSendCommon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main2);
        btnSendCommon = findViewById(R.id.btn_send_common);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
        btnSendCommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBusUtil.sendStickyEvent(new Event(Constants.EventBusCode.EVENT_BUS_CODE_C));
            }
        });
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected void receiveEvent(Event event) {
        super.receiveEvent(event);
        Log.e("接收到普通事件", getClass().getName() + "--->" + event.getCode() + "<---");
    }

    @Override
    protected void receiveStickyEvent(Event event) {
        super.receiveStickyEvent(event);
        Log.e("接收到粘滞事件", getClass().getName() + "--->" + event.getCode() + "<---");
    }
}
