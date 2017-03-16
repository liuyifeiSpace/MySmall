package com.ht.mysmall.app.main.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import net.wequick.small.Small;

import java.util.ArrayList;


public class FragmentController
{

    private static FragmentController controller;
    private int containerId;
    private FragmentManager fm;
    private ArrayList<Fragment> fragments;
    private FragmentActivity activity;

    private FragmentController(FragmentActivity activity, int containerId)
    {
        this.activity = activity;
        this.containerId = containerId;
        fm = activity.getSupportFragmentManager();
        initFragment();
    }

    public static FragmentController getInstance(FragmentActivity activity, int containerId)
    {
        if (controller == null)
        {
            controller = new FragmentController(activity, containerId);
        }
        return controller;
    }

    public static void onDestroy()
    {
        controller = null;
    }

    public static void onDestoryController()
    {
        if (controller != null)
        {
            controller.onDestoryController();
            controller = null;
        }
    }

    private void initFragment()
    {
        fragments = new ArrayList<Fragment>();

        fragments.add((Fragment) Small.createObject("fragment-v4", "message", activity));
        fragments.add((Fragment) Small.createObject("fragment-v4", "contact", activity));
        fragments.add((Fragment) Small.createObject("fragment-v4", "mine", activity));

        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments)
        {
            ft.add(containerId, fragment);
        }
        ft.commitAllowingStateLoss();
    }

    public void showFragment(int position)
    {
        hideFragments();
        Fragment fragment = fragments.get(position);
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commitAllowingStateLoss();
    }

    public void hideFragments()
    {
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments)
        {
            if (fragment != null)
            {
                ft.hide(fragment);
            }
        }
        ft.commitAllowingStateLoss();
    }

    public Fragment getFragment(int position)
    {
        return fragments.get(position);
    }
}