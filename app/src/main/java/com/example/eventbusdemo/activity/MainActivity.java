package com.example.eventbusdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.eventbusdemo.R;
import com.example.eventbusdemo.base.CommonBaseActivity;
import com.example.eventbusdemo.config.Constants;
import com.example.eventbusdemo.event.Event;
import com.example.eventbusdemo.util.EventBusUtil;

public class MainActivity extends CommonBaseActivity {

    private Button btnSendCommon;
    private Button btnSendStick;
    private Button btnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        btnJump = findViewById(R.id.btn_jump);
        btnSendCommon = findViewById(R.id.btn_send_common);
        btnSendStick = findViewById(R.id.btn_send_sticky);
        super.onCreate(savedInstanceState);

    }

    protected void initData() {
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
        btnSendCommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBusUtil.sendStickyEvent(new Event(Constants.EventBusCode.EVENT_BUS_CODE_A));
            }
        });

        btnSendStick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBusUtil.sendStickyEvent(new Event(Constants.EventBusCode.EVENT_BUS_CODE_B));
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
