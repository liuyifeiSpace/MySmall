package com.ht.mysmall.base;

import android.app.Application;

import net.wequick.small.Small;

/**
 * Created by Administrator on 2017/3/7.
 */

public class AppContext extends Application
{
    public AppContext()
    {
        Small.preSetUp(this);
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
    }
}
