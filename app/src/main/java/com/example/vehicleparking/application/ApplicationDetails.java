package com.example.vehicleparking.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;


public class ApplicationDetails extends Application {
    public final String TAG = ApplicationDetails.class.getSimpleName();
    private static ApplicationDetails instance = null;
    private Activity mActivity = null;

    public ApplicationDetails() {
        instance = this;
    }

    public static ApplicationDetails getInstance() {
        return (instance == null) ? (instance = new ApplicationDetails()) : instance;
    }

    private Activity mCurrentActivity = null;
    private String screenName = "";

    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentActivity(Activity mCurrentActivity) {
        this.mCurrentActivity = mCurrentActivity;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Context getContext() {
        return getApplicationContext();
    }
}