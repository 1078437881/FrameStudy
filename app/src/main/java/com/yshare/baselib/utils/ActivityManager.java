package com.yshare.baselib.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.util.Stack;

/**
 * Created by Administrator on 2018/3/15.
 */

public class ActivityManager {

    private static String TAG = "ActivityManager";
    private static Stack<Activity> activityStack;
    private static ActivityManager instance;

    private ActivityManager(){

    }

    /**
     * 单一实例
     * @return
     */
    public static synchronized ActivityManager getAppInstance(){
        if (instance==null){
            instance = new ActivityManager();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     * @param activity
     */
    public synchronized void addActivity(Activity activity){
        if (activityStack==null){
            activityStack=new Stack<>();
        }
        activityStack.add(activity);
        Log.i(TAG,"添加了:"+activity.getClass().getName());
    }

    /**
     * 获取当前Activity(堆栈最后一个入栈)
     * @return
     */
    public Activity currentActivity(){
        return activityStack.lastElement();
    }

    /**
     * 结束当前Activity
     */
    public void finishActivity(){
        finishActivity(activityStack.lastElement());
    }

    /**
     * 结束指定Activity
     * @param activity
     */
    public void finishActivity(Activity activity){
        if (activity!=null){
            activityStack.remove(activity);
            activity.finish();
            Log.i(TAG,"关闭了:"+activity.getClass().getName());
        }
    }

    /**
     * 移除指定Activity
     * @param activity
     */
    public void removeActivity(Activity activity){
        if (activity!=null){
            activityStack.remove(activity);
            Log.i(TAG,"移除了:"+activity.getClass().getName());
        }
    }

    /**
     * 结束指定类名的Activity
     * @param cls
     */
    public void finishActivity(Class<?> cls){
        for (int i=0;i<activityStack.size();i++){
            if(activityStack.get(i).getClass().equals(cls)){
                finishActivity(activityStack.get(i));
                removeActivity(activityStack.get(i));
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity(){
        for (Activity activity : activityStack){
            if (activity!=null){
                activity.finish();
            }
        }
        activityStack.clear();
    }


    /**
     * 结束所有Activity,退出应用
     * @param context
     */
    public void AppExit(Context context){
        try{
            finishAllActivity();
            android.app.ActivityManager activityMgr = (android.app.ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
