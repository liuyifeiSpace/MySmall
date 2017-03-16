package com.ht.mysmall;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

import net.wequick.small.Small;

public class MainActivity extends Activity
{
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            Small.openUri("main",MainActivity.this);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Small.setUp(MainActivity.this, new Small.OnCompleteListener()
        {
            @Override
            public void onComplete()
            {
                handler.sendEmptyMessageDelayed(0,3000);
            }
        });
    }
}
