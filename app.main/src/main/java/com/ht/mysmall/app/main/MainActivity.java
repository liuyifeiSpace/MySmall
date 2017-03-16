package com.ht.mysmall.app.main;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ht.mysmall.app.main.base.FragmentController;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener
{
    RadioGroup hometabRadio;
    private FragmentController controller;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);
        hometabRadio = (RadioGroup) findViewById(R.id.radioGroup);
        hometabRadio.setOnCheckedChangeListener(this);
        tv_title = (TextView) findViewById(R.id.title);
        controller = FragmentController.getInstance(this, R.id.content);
        controller.showFragment(0);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        switch (checkedId)
        {

            case R.id.rb_menu_pic:
                tv_title.setText("消息");
                controller.showFragment(0);
                Toast.makeText(MainActivity.this,"你点击了消息",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_menu_video:
                tv_title.setText("联系人");
                controller.showFragment(1);
                break;
            case R.id.rb_menu_me:
                tv_title.setText("我的");
                controller.showFragment(2);
                break;
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        FragmentController.onDestoryController();
    }
}
